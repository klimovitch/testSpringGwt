package com.google.gwt.useragent.client;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class UserAgentAsserter_UserAgentAssertionError_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.google.gwt.useragent.client.UserAgentAsserter.UserAgentAssertionError instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.AssertionError_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.google.gwt.useragent.client.UserAgentAsserter.UserAgentAssertionError instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.google.gwt.useragent.client.UserAgentAsserter.UserAgentAssertionError();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.google.gwt.useragent.client.UserAgentAsserter.UserAgentAssertionError instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.AssertionError_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.google.gwt.useragent.client.UserAgentAsserter_UserAgentAssertionError_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.google.gwt.useragent.client.UserAgentAsserter_UserAgentAssertionError_FieldSerializer.deserialize(reader, (com.google.gwt.useragent.client.UserAgentAsserter.UserAgentAssertionError)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.google.gwt.useragent.client.UserAgentAsserter_UserAgentAssertionError_FieldSerializer.serialize(writer, (com.google.gwt.useragent.client.UserAgentAsserter.UserAgentAssertionError)object);
  }
  
}
