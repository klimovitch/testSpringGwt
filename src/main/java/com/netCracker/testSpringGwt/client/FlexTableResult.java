package com.netCracker.testSpringGwt.client;

import com.google.gwt.user.client.ui.FlexTable;

public class FlexTableResult extends FlexTable {

	ButtonWithIndex button;

	public FlexTableResult() {
		super();
	}

	int searchFlexTable(FlexTable flexTable, ButtonWithIndex button) {
		int rowIndex = 100;
		for (int i = 0; i < flexTable.getRowCount(); i++) {
			for (int j = 0; j < flexTable.getCellCount(i); j++) {
				if (button.equals(flexTable.getWidget(i, j))) {
					return rowIndex = i;
				}
			}
		}
		return rowIndex;
	}

}
