package com.netCracker.testSpringGwt.shared.services;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.RpcToken;
import com.google.gwt.user.client.rpc.RpcTokenException;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.impl.RpcStatsContext;

public class CustomerService_Proxy extends RemoteServiceProxy implements com.netCracker.testSpringGwt.shared.services.CustomerServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "com.netCracker.testSpringGwt.shared.services.CustomerService";
  private static final String SERIALIZATION_POLICY ="4E77E62D095CDE903E1282B5DAEC6C81";
  private static final com.netCracker.testSpringGwt.shared.services.CustomerService_TypeSerializer SERIALIZER = new com.netCracker.testSpringGwt.shared.services.CustomerService_TypeSerializer();
  
  public CustomerService_Proxy() {
    super(GWT.getModuleBaseURL(),
      "springGwtServices/customerService", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void deleteCustomer(long customerId, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("CustomerService_Proxy", "deleteCustomer");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("J");
      streamWriter.writeLong(customerId);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void findAllCustomersByMetaphone(java.lang.String customerFirstName, java.lang.String customerLastName, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("CustomerService_Proxy", "findAllCustomersByMetaphone");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(customerFirstName);
      streamWriter.writeString(customerLastName);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void findCustomer(long customerId, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("CustomerService_Proxy", "findCustomer");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("J");
      streamWriter.writeLong(customerId);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void findLastModifed(int maxResult, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("CustomerService_Proxy", "findLastModifed");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("I");
      streamWriter.writeInt(maxResult);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getAllTypesCustomer(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("CustomerService_Proxy", "getAllTypesCustomer");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 0);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void saveCustomer(java.lang.String customerTitle, java.lang.String customerFirstName, java.lang.String customerLastName, java.util.Date customerLastModified, java.lang.String customerType, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("CustomerService_Proxy", "saveCustomer");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 5);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.util.Date/3385151746");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(customerTitle);
      streamWriter.writeString(customerFirstName);
      streamWriter.writeString(customerLastName);
      streamWriter.writeObject(customerLastModified);
      streamWriter.writeString(customerType);
      helper.finish(callback, ResponseReader.BOOLEAN);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void updateCustomer(com.netCracker.testSpringGwt.shared.dto.CustomerDTO customer, java.lang.String customerTitle, java.lang.String customerFirstName, java.lang.String customerLastName, java.util.Date customerLastModified, java.lang.String customerType, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("CustomerService_Proxy", "updateCustomer");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 6);
      streamWriter.writeString("com.netCracker.testSpringGwt.shared.dto.CustomerDTO/2205888276");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.util.Date/3385151746");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeObject(customer);
      streamWriter.writeString(customerTitle);
      streamWriter.writeString(customerFirstName);
      streamWriter.writeString(customerLastName);
      streamWriter.writeObject(customerLastModified);
      streamWriter.writeString(customerType);
      helper.finish(callback, ResponseReader.VOID);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  @Override
  public SerializationStreamWriter createStreamWriter() {
    ClientSerializationStreamWriter toReturn =
      (ClientSerializationStreamWriter) super.createStreamWriter();
    if (getRpcToken() != null) {
      toReturn.addFlags(ClientSerializationStreamWriter.FLAG_RPC_TOKEN_INCLUDED);
    }
    return toReturn;
  }
  @Override
  protected void checkRpcTokenType(RpcToken token) {
    if (!(token instanceof com.google.gwt.user.client.rpc.XsrfToken)) {
      throw new RpcTokenException("Invalid RpcToken type: expected 'com.google.gwt.user.client.rpc.XsrfToken' but got '" + token.getClass() + "'");
    }
  }
}
