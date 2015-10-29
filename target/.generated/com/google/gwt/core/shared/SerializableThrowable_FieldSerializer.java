package com.google.gwt.core.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class SerializableThrowable_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.google.gwt.user.client.rpc.core.com.google.gwt.core.shared.SerializableThrowable_CustomFieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.google.gwt.user.client.rpc.core.com.google.gwt.core.shared.SerializableThrowable_CustomFieldSerializer.deserialize(reader, (com.google.gwt.core.shared.SerializableThrowable)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.google.gwt.user.client.rpc.core.com.google.gwt.core.shared.SerializableThrowable_CustomFieldSerializer.serialize(writer, (com.google.gwt.core.shared.SerializableThrowable)object);
  }
  
}
