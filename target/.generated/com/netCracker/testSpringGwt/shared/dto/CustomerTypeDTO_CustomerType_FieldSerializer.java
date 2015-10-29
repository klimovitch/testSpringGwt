package com.netCracker.testSpringGwt.shared.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CustomerTypeDTO_CustomerType_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO.CustomerType instance) throws SerializationException {
    // Enum deserialization is handled via the instantiate method
  }
  
  public static com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO.CustomerType instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int ordinal = streamReader.readInt();
    com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO.CustomerType[] values = com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO.CustomerType.values();
    assert (ordinal >= 0 && ordinal < values.length);
    return values[ordinal];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO.CustomerType instance) throws SerializationException {
    assert (instance != null);
    streamWriter.writeInt(instance.ordinal());
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO_CustomerType_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO_CustomerType_FieldSerializer.deserialize(reader, (com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO.CustomerType)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO_CustomerType_FieldSerializer.serialize(writer, (com.netCracker.testSpringGwt.shared.dto.CustomerTypeDTO.CustomerType)object);
  }
  
}
