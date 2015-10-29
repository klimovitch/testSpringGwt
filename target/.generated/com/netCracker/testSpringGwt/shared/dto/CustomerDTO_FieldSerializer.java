package com.netCracker.testSpringGwt.shared.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CustomerDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getCustomerFirstName(com.netCracker.testSpringGwt.shared.dto.CustomerDTO instance) /*-{
    return instance.@com.netCracker.testSpringGwt.shared.dto.CustomerDTO::customerFirstName;
  }-*/;
  
  private static native void setCustomerFirstName(com.netCracker.testSpringGwt.shared.dto.CustomerDTO instance, java.lang.String value) 
  /*-{
    instance.@com.netCracker.testSpringGwt.shared.dto.CustomerDTO::customerFirstName = value;
  }-*/;
  
  private static native java.lang.String getCustomerFirstNameMetaphone(com.netCracker.testSpringGwt.shared.dto.CustomerDTO instance) /*-{
    return instance.@com.netCracker.testSpringGwt.shared.dto.CustomerDTO::customerFirstNameMetaphone;
  }-*/;
  
  private static native void setCustomerFirstNameMetaphone(com.netCracker.testSpringGwt.shared.dto.CustomerDTO instance, java.lang.String value) 
  /*-{
    instance.@com.netCracker.testSpringGwt.shared.dto.CustomerDTO::customerFirstNameMetaphone = value;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native long getCustomerId(com.netCracker.testSpringGwt.shared.dto.CustomerDTO instance) /*-{
    return instance.@com.netCracker.testSpringGwt.shared.dto.CustomerDTO::customerId;
  }-*/;
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static native void setCustomerId(com.netCracker.testSpringGwt.shared.dto.CustomerDTO instance, long value) 
  /*-{
    instance.@com.netCracker.testSpringGwt.shared.dto.CustomerDTO::customerId = value;
  }-*/;
  
  private static native java.util.Date getCustomerLastModified(com.netCracker.testSpringGwt.shared.dto.CustomerDTO instance) /*-{
    return instance.@com.netCracker.testSpringGwt.shared.dto.CustomerDTO::customerLastModified;
  }-*/;
  
  private static native void setCustomerLastModified(com.netCracker.testSpringGwt.shared.dto.CustomerDTO instance, java.util.Date value) 
  /*-{
    instance.@com.netCracker.testSpringGwt.shared.dto.CustomerDTO::customerLastModified = value;
  }-*/;
  
  private static native java.lang.String getCustomerLastName(com.netCracker.testSpringGwt.shared.dto.CustomerDTO instance) /*-{
    return instance.@com.netCracker.testSpringGwt.shared.dto.CustomerDTO::customerLastName;
  }-*/;
  
  private static native void setCustomerLastName(com.netCracker.testSpringGwt.shared.dto.CustomerDTO instance, java.lang.String value) 
  /*-{
    instance.@com.netCracker.testSpringGwt.shared.dto.CustomerDTO::customerLastName = value;
  }-*/;
  
  private static native java.lang.String getCustomerLastNameMetaphone(com.netCracker.testSpringGwt.shared.dto.CustomerDTO instance) /*-{
    return instance.@com.netCracker.testSpringGwt.shared.dto.CustomerDTO::customerLastNameMetaphone;
  }-*/;
  
  private static native void setCustomerLastNameMetaphone(com.netCracker.testSpringGwt.shared.dto.CustomerDTO instance, java.lang.String value) 
  /*-{
    instance.@com.netCracker.testSpringGwt.shared.dto.CustomerDTO::customerLastNameMetaphone = value;
  }-*/;
  
  private static native java.lang.String getCustomerTitle(com.netCracker.testSpringGwt.shared.dto.CustomerDTO instance) /*-{
    return instance.@com.netCracker.testSpringGwt.shared.dto.CustomerDTO::customerTitle;
  }-*/;
  
  private static native void setCustomerTitle(com.netCracker.testSpringGwt.shared.dto.CustomerDTO instance, java.lang.String value) 
  /*-{
    instance.@com.netCracker.testSpringGwt.shared.dto.CustomerDTO::customerTitle = value;
  }-*/;
  
  private static native com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO getCustomerType(com.netCracker.testSpringGwt.shared.dto.CustomerDTO instance) /*-{
    return instance.@com.netCracker.testSpringGwt.shared.dto.CustomerDTO::customerType;
  }-*/;
  
  private static native void setCustomerType(com.netCracker.testSpringGwt.shared.dto.CustomerDTO instance, com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO value) 
  /*-{
    instance.@com.netCracker.testSpringGwt.shared.dto.CustomerDTO::customerType = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.netCracker.testSpringGwt.shared.dto.CustomerDTO instance) throws SerializationException {
    com.google.gwt.core.client.impl.WeakMapping.set(instance, "server-enhanced-data-1", streamReader.readString());
    setCustomerFirstName(instance, streamReader.readString());
    setCustomerFirstNameMetaphone(instance, streamReader.readString());
    setCustomerId(instance, streamReader.readLong());
    setCustomerLastModified(instance, (java.util.Date) streamReader.readObject());
    setCustomerLastName(instance, streamReader.readString());
    setCustomerLastNameMetaphone(instance, streamReader.readString());
    setCustomerTitle(instance, streamReader.readString());
    setCustomerType(instance, (com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO) streamReader.readObject());
    
  }
  
  public static com.netCracker.testSpringGwt.shared.dto.CustomerDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.netCracker.testSpringGwt.shared.dto.CustomerDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.netCracker.testSpringGwt.shared.dto.CustomerDTO instance) throws SerializationException {
    streamWriter.writeString((String) com.google.gwt.core.client.impl.WeakMapping.get(instance, "server-enhanced-data-1"));
    streamWriter.writeString(getCustomerFirstName(instance));
    streamWriter.writeString(getCustomerFirstNameMetaphone(instance));
    streamWriter.writeLong(getCustomerId(instance));
    streamWriter.writeObject(getCustomerLastModified(instance));
    streamWriter.writeString(getCustomerLastName(instance));
    streamWriter.writeString(getCustomerLastNameMetaphone(instance));
    streamWriter.writeString(getCustomerTitle(instance));
    streamWriter.writeObject(getCustomerType(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.netCracker.testSpringGwt.shared.dto.CustomerDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.netCracker.testSpringGwt.shared.dto.CustomerDTO_FieldSerializer.deserialize(reader, (com.netCracker.testSpringGwt.shared.dto.CustomerDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.netCracker.testSpringGwt.shared.dto.CustomerDTO_FieldSerializer.serialize(writer, (com.netCracker.testSpringGwt.shared.dto.CustomerDTO)object);
  }
  
}
