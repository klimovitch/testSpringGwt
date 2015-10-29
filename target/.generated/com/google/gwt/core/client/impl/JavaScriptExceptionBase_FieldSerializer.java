package com.google.gwt.core.client.impl;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class JavaScriptExceptionBase_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.google.gwt.core.client.impl.JavaScriptExceptionBase instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.google.gwt.core.client.impl.JavaScriptExceptionBase instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.google.gwt.core.client.impl.JavaScriptExceptionBase();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.google.gwt.core.client.impl.JavaScriptExceptionBase instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.google.gwt.core.client.impl.JavaScriptExceptionBase_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.google.gwt.core.client.impl.JavaScriptExceptionBase_FieldSerializer.deserialize(reader, (com.google.gwt.core.client.impl.JavaScriptExceptionBase)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.google.gwt.core.client.impl.JavaScriptExceptionBase_FieldSerializer.serialize(writer, (com.google.gwt.core.client.impl.JavaScriptExceptionBase)object);
  }
  
}
