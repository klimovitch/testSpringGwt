package com.netCracker.testSpringGwt.shared.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CustomerDTO_Array_Rank_1_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.netCracker.testSpringGwt.shared.dto.CustomerDTO[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.netCracker.testSpringGwt.shared.dto.CustomerDTO[] instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int size = streamReader.readInt();
    return new com.netCracker.testSpringGwt.shared.dto.CustomerDTO[size];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.netCracker.testSpringGwt.shared.dto.CustomerDTO[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.netCracker.testSpringGwt.shared.dto.CustomerDTO_Array_Rank_1_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.netCracker.testSpringGwt.shared.dto.CustomerDTO_Array_Rank_1_FieldSerializer.deserialize(reader, (com.netCracker.testSpringGwt.shared.dto.CustomerDTO[])object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.netCracker.testSpringGwt.shared.dto.CustomerDTO_Array_Rank_1_FieldSerializer.serialize(writer, (com.netCracker.testSpringGwt.shared.dto.CustomerDTO[])object);
  }
  
}
