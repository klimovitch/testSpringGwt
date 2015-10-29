package com.netCracker.testSpringGwt.shared.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CustomerTypeDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getCustomerId(com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO instance) /*-{
    return instance.@com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO::customerId;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setCustomerId(com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO instance, long value) 
  /*-{
    instance.@com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO::customerId = value;
  }-*/;
  
  private static native com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO.CustomerType getCustomerType(com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO instance) /*-{
    return instance.@com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO::customerType;
  }-*/;
  
  private static native void setCustomerType(com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO instance, com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO.CustomerType value) 
  /*-{
    instance.@com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO::customerType = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO instance) throws SerializationException {
    com.google.gwt.core.client.impl.WeakMapping.set(instance, "server-enhanced-data-1", streamReader.readString());
    setCustomerId(instance, streamReader.readLong());
    setCustomerType(instance, (com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO.CustomerType) streamReader.readObject());
    
  }
  
  public static com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO instance) throws SerializationException {
    streamWriter.writeString((String) com.google.gwt.core.client.impl.WeakMapping.get(instance, "server-enhanced-data-1"));
    streamWriter.writeLong(getCustomerId(instance));
    streamWriter.writeObject(getCustomerType(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO_FieldSerializer.deserialize(reader, (com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO_FieldSerializer.serialize(writer, (com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO)object);
  }
  
}
