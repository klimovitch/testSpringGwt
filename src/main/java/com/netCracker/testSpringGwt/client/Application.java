package com.netCracker.testSpringGwt.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
//import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.netCracker.testSpringGwt.shared.dto.CustomerDTO;
import com.netCracker.testSpringGwt.shared.services.CustomerServiceAsync;

public class Application implements EntryPoint {

	private static final String SERVER_ERROR = "An error occurred while " + "attempting to contact the server. Please check your network "
			+ "connection and try again. The error is : ";

	private final CustomerServiceAsync customerService = CustomerServiceAsync.Util.getInstance();

	@Override
	public void onModuleLoad() {

		final Button saveButton = new Button("Save");
		final Button updateButton = new Button("Update");
		final Button findButton = new Button("Find");

		MultiWordSuggestOracle title = new MultiWordSuggestOracle();
		title.add("MR");
		title.add("Ms");
		title.add("Mrs");
		title.add("Dr");

		final SuggestBox customerTitleSuggestionBox = new SuggestBox(title);
		final TextBox customerFNameField = new TextBox();
		final TextBox customerLNameField = new TextBox();

		final ListBox customerTypeListBox = new ListBox();
		customerService.getAllTypesCustomer(new AsyncCallback<List<String>>() {
			public void onFailure(Throwable caught) {
			}

			public void onSuccess(List<String> result) {
				for (String i : result) {
					customerTypeListBox.addItem(i);
				}
			}
		});

		customerTitleSuggestionBox.setText("Customer Title");
		customerFNameField.setText("Customer First Name");
		customerLNameField.setText("Customer Last Name");

		final TextBox customerFindFNameField = new TextBox();
		final TextBox customerFindLNameField = new TextBox();

		final Label errorLabel = new Label();

		final FlexTableResult flexTable = new FlexTableResult();

		final Hidden hiddenForEditCustomer = new Hidden();

		RootPanel.get("customerTitleFieldContainer").add(customerTitleSuggestionBox);
		RootPanel.get("customerFNameFieldContainer").add(customerFNameField);
		RootPanel.get("customerLNameFieldContainer").add(customerLNameField);
		RootPanel.get("customerTypeLBContainer").add(customerTypeListBox);
		RootPanel.get("saveCustomerButtonContainer").add(saveButton);
		RootPanel.get("updateCustomerButtonContainer").add(updateButton);
		RootPanel.get("customerFindFNameFieldContainer").add(customerFindFNameField);
		RootPanel.get("customerFindLNameFieldContainer").add(customerFindLNameField);
		RootPanel.get("findCustomerButtonContainer").add(findButton);
		RootPanel.get("errorLabelContainer").add(errorLabel);
		RootPanel.get("customerFlexTableContainer").add(flexTable);
		RootPanel.get("hiddenContainer").add(hiddenForEditCustomer);

		// Focus the cursor on the name field when the app loads
		customerTitleSuggestionBox.setFocus(true);

		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");

		// Set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending request to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);

		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();
				saveButton.setEnabled(true);
				saveButton.setFocus(true);
				updateButton.setEnabled(true);
				findButton.setEnabled(true);
			}
		});

		// Create a handler for the saveButton, updateButton and customerInfoField
		class SaveOrUpdateCustomerHandler implements ClickHandler, KeyUpHandler {

			public void onClick(ClickEvent event) {
				// Check which button was pressed
				Widget sender = (Widget) event.getSource();

				if (sender == saveButton) {
					sendCustomerInfoToServer("saveButton");
				} else if (sender == updateButton) {
					sendCustomerInfoToServer("updateButton");
				}
			}

			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					Widget sender = (Widget) event.getSource();
					if (sender == saveButton) {
						sendCustomerInfoToServer("saveButton");
					} else if (sender == updateButton) {
						sendCustomerInfoToServer("updateButton");
					}
				}
			}

			private void sendCustomerInfoToServer(String nameButton) {
				// First, we validate the input.
				errorLabel.setText("");

				// Then, we send the input to the server.
				saveButton.setEnabled(false);
				serverResponseLabel.setText("");

				String customerTitle = customerTitleSuggestionBox.getText();
				String customerFirstName = customerFNameField.getText();
				String customerLastName = customerLNameField.getText();

				final String customerType = customerTypeListBox.getSelectedValue();
				Date customerLastModified = new Date(System.currentTimeMillis());

				// Validation input text
				if (ValidationUtils.isNotEnglishString(customerFirstName) && ValidationUtils.isNotEnglishString(customerLastName)) {

					Window.alert("Please enter only in English");

				} else {

					textToServerLabel.setText("Customer: " + customerTitle + " " + customerFirstName + " " + customerLastName + " " + customerType);

					if (nameButton.equals("saveButton")) {
						customerService.saveCustomer(customerTitle, customerFirstName, customerLastName, customerLastModified, customerType,
								new AsyncCallback<Boolean>() {
									public void onFailure(Throwable caught) {
										// Show the RPC error message to the user
										dialogBox.setText("Remote Procedure Call - Failure");
										serverResponseLabel.addStyleName("serverResponseLabelError");
										serverResponseLabel.setHTML(SERVER_ERROR + caught.toString());
										dialogBox.center();
										closeButton.setFocus(true);
									}

									public void onSuccess(Boolean saved) {
										if (saved) {
											dialogBox.setText("Remote Procedure Call - Save was successful");
										} else {
											dialogBox.setText("Remote Procedure Call - Customer exist");
										}
										serverResponseLabel.removeStyleName("serverResponseLabelError");
										serverResponseLabel.setHTML("OK");
										dialogBox.center();
										closeButton.setFocus(true);
									}
								});

					} else if (nameButton.equals("updateButton")) {
						customerService.updateCustomer((CustomerDTO) hiddenForEditCustomer.getLayoutData(), customerTitle, customerFirstName,
								customerLastName, customerLastModified, customerType, new AsyncCallback<Void>() {
									public void onFailure(Throwable caught) {
										// Show the RPC error message to the user
										dialogBox.setText("Remote Procedure Call - Failure");
										serverResponseLabel.addStyleName("serverResponseLabelError");
										serverResponseLabel.setHTML(SERVER_ERROR + caught.toString());
										dialogBox.center();
										closeButton.setFocus(true);
									}

									public void onSuccess(Void noAnswer) {
										dialogBox.setText("Remote Procedure Call - Update was successful");
										serverResponseLabel.removeStyleName("serverResponseLabelError");
										serverResponseLabel.setHTML("OK");
										dialogBox.center();
										closeButton.setFocus(true);
									}
								});
					}
				}
			}
		}

		// Create a handler for the findButton and customerField
		class FindCustomerHandler implements ClickHandler, KeyUpHandler {

			public void onClick(ClickEvent event) {
				sendCustomerIdToServer();
			}

			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendCustomerIdToServer();
				}
			}

			private void sendCustomerIdToServer() {
				// First, we validate the input.
				errorLabel.setText("");

				String customerFName = customerFindFNameField.getText();
				String customerLName = customerFindLNameField.getText();

				// Then, we send the input to the server.
				// retrieveButton.setEnabled(false);

				serverResponseLabel.setText("");

				// validation field: is not empty and in English
				if (ValidationUtils.isEnglishString(customerFName) && ValidationUtils.isEnglishString(customerLName)) {
					customerService.findAllCustomersByMetaphone(customerFName, customerLName, new AsyncCallback<List<CustomerDTO>>() {
						public void onFailure(Throwable caught) {
							// Show the RPC error message to the user
							dialogBox.setText("Remote Procedure Call - Failure");
							serverResponseLabel.addStyleName("serverResponseLabelError");
							serverResponseLabel.setHTML(SERVER_ERROR + caught.toString());
							dialogBox.center();
							closeButton.setFocus(true);
						}

						public void onSuccess(List<CustomerDTO> listCustomersDTO) {
							if (listCustomersDTO.size() == 0) {
								dialogBox.setText("Remote Procedure Call - Customer not found");
								serverResponseLabel.removeStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML("OK");
								dialogBox.center();
								closeButton.setFocus(true);
							}
							flexTable.removeAllRows();
							// show result of find in FlexTable: sorted ORDER BY MODIFED_WHEN DESC
							createFlexTable(listCustomersDTO, createDeleteButtons(listCustomersDTO, listCustomersDTO.size()),
									createEditButtons(listCustomersDTO, listCustomersDTO.size()));

						}
					});
					// validation field: is empty
					// show last 10 modified Customers in FlexTable: sorted ORDER BY MODIFED_WHEN DESC
				} else if (ValidationUtils.isBlank(customerFName) && ValidationUtils.isBlank(customerLName)) {
					customerService.findLastModifed(10, new AsyncCallback<List<CustomerDTO>>() {
						public void onFailure(Throwable caught) {
							// Show the RPC error message to the user
							dialogBox.setText("Remote Procedure Call - Failure");
							serverResponseLabel.addStyleName("serverResponseLabelError");
							serverResponseLabel.setHTML(SERVER_ERROR + caught.toString());
							dialogBox.center();
							closeButton.setFocus(true);
						}

						public void onSuccess(List<CustomerDTO> listCustomersDTO) {
							flexTable.removeAllRows();
							createFlexTable(listCustomersDTO, createDeleteButtons(listCustomersDTO, listCustomersDTO.size()),
									createEditButtons(listCustomersDTO, listCustomersDTO.size()));

						}
					});
				}

			}

			// Create ArayList of Delete buttons, add Handlers
			private ArrayList<ButtonWithIndex> createDeleteButtons(List<CustomerDTO> listCustomersDTO, int rows) {
				ArrayList<ButtonWithIndex> deleteButtonsList = new ArrayList<ButtonWithIndex>();
				for (final CustomerDTO i : listCustomersDTO) {
					final ButtonWithIndex button = new ButtonWithIndex("Delete", listCustomersDTO.indexOf(i));
					deleteButtonsList.add(button);

					button.addClickHandler(new ClickHandler() {

						public void onClick(ClickEvent event) {
							int removeRow = flexTable.searchFlexTable(flexTable, button);
							String fNameDelete = ((Label) flexTable.getWidget(removeRow, 1)).getText();
							String lNameDelete = ((Label) flexTable.getWidget(removeRow, 2)).getText();
							Window.alert("Confirm remove: " + fNameDelete + " " + lNameDelete);
							flexTable.removeRow(removeRow);

							customerService.deleteCustomer(i.getCustomerId(), new AsyncCallback<CustomerDTO>() {
								public void onFailure(Throwable caught) {
									// Show the RPC error message to the user
									dialogBox.setText("Remote Procedure Call - Failure");
									serverResponseLabel.addStyleName("serverResponseLabelError");
									serverResponseLabel.setHTML(SERVER_ERROR + caught.toString());
									dialogBox.center();
									closeButton.setFocus(true);
								}

								public void onSuccess(CustomerDTO customerDTO) {
									dialogBox.setText("Remote Procedure Call - Customer was deleted from Data Base");
									textToServerLabel.setText("Customer: " + customerDTO.getCustomerTitle() + " " + customerDTO.getCustomerFirstName()
											+ " " + customerDTO.getCustomerLastName() + " " + customerDTO.getCustomerType().getCustomerType());
									serverResponseLabel.removeStyleName("serverResponseLabelError");
									serverResponseLabel.setHTML("OK");
									dialogBox.center();
									closeButton.setFocus(true);
								}
							});
						}
					});
				}
				return deleteButtonsList;
			}

			// Create ArayList of Edit buttons, add Handlers
			private ArrayList<ButtonWithIndex> createEditButtons(List<CustomerDTO> listCustomersDTO, int rows) {
				ArrayList<ButtonWithIndex> editButtonsList = new ArrayList<ButtonWithIndex>();
				for (final CustomerDTO i : listCustomersDTO) {
					final ButtonWithIndex button = new ButtonWithIndex("Edit", listCustomersDTO.indexOf(i));
					editButtonsList.add(button);
					button.addClickHandler(new ClickHandler() {
						public void onClick(ClickEvent event) {
							int editRow = flexTable.searchFlexTable(flexTable, button);
							String titleEdit = ((Label) flexTable.getWidget(editRow, 0)).getText();
							String fNameEdit = ((Label) flexTable.getWidget(editRow, 1)).getText();
							String lNameEdit = ((Label) flexTable.getWidget(editRow, 2)).getText();

							Window.alert("Confirm edit: " + fNameEdit + " " + lNameEdit);
							saveButton.setEnabled(true);
							// set Customer in field for edit
							customerTitleSuggestionBox.setText(titleEdit);
							customerFNameField.setText(fNameEdit);
							customerLNameField.setText(lNameEdit);

							// write in Hidden Field CustomerDTO for edit
							hiddenForEditCustomer.setLayoutData(i);

						}
					});
				}
				return editButtonsList;
			}

			// create FlexRows with result of find and buttons
			private void createFlexTable(List<CustomerDTO> listCustomersDTO, ArrayList<ButtonWithIndex> deleteButtonsList,
					ArrayList<ButtonWithIndex> editButtonsList) {
				flexTable.setText(0, 0, "Title");
				flexTable.setText(0, 1, "First Name");
				flexTable.setText(0, 2, "Last Name");
				flexTable.setText(0, 3, "Type");
				flexTable.setText(0, 4, "Last Modified");
				for (CustomerDTO i : listCustomersDTO) {
					int numRows = flexTable.getRowCount();
					flexTable.setWidget(numRows, 0, new Label(i.getCustomerTitle()));
					flexTable.setWidget(numRows, 1, new Label(i.getCustomerFirstName()));
					flexTable.setWidget(numRows, 2, new Label(i.getCustomerLastName()));
					flexTable.setWidget(numRows, 3, new Label(i.getCustomerType().getCustomerType().toString()));
					flexTable.setWidget(numRows, 4, new Label(i.getCustomerLastModified().toString()));
					flexTable.setWidget(numRows, 5, deleteButtonsList.get(listCustomersDTO.indexOf(i)));
					flexTable.setWidget(numRows, 6, editButtonsList.get(listCustomersDTO.indexOf(i)));
				}
			}
		}

		// Add a handler to send the customer info to the server for Save, Update
		SaveOrUpdateCustomerHandler saveOrUpdateCustomerHandler = new SaveOrUpdateCustomerHandler();
		saveButton.addClickHandler(saveOrUpdateCustomerHandler);
		updateButton.addClickHandler(saveOrUpdateCustomerHandler);

		// Add a handler to send the customer info to the server for Find
		FindCustomerHandler findCustomerHandler = new FindCustomerHandler();
		findButton.addClickHandler(findCustomerHandler);

	}
}
