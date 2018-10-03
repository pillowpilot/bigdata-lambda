/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.politecnica.bigdata.batchlayer.model;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2018-10-02")
public class WeaponProperty implements org.apache.thrift.TBase<WeaponProperty, WeaponProperty._Fields>, java.io.Serializable, Cloneable, Comparable<WeaponProperty> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("WeaponProperty");

  private static final org.apache.thrift.protocol.TField WEAPON_FIELD_DESC = new org.apache.thrift.protocol.TField("weapon", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField PROPERTY_FIELD_DESC = new org.apache.thrift.protocol.TField("property", org.apache.thrift.protocol.TType.STRUCT, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new WeaponPropertyStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new WeaponPropertyTupleSchemeFactory();

  public WeaponID weapon; // required
  public WeaponPropertyValue property; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    WEAPON((short)1, "weapon"),
    PROPERTY((short)2, "property");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // WEAPON
          return WEAPON;
        case 2: // PROPERTY
          return PROPERTY;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.WEAPON, new org.apache.thrift.meta_data.FieldMetaData("weapon", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, WeaponID.class)));
    tmpMap.put(_Fields.PROPERTY, new org.apache.thrift.meta_data.FieldMetaData("property", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT        , "WeaponPropertyValue")));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(WeaponProperty.class, metaDataMap);
  }

  public WeaponProperty() {
  }

  public WeaponProperty(
    WeaponID weapon,
    WeaponPropertyValue property)
  {
    this();
    this.weapon = weapon;
    this.property = property;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public WeaponProperty(WeaponProperty other) {
    if (other.isSetWeapon()) {
      this.weapon = new WeaponID(other.weapon);
    }
    if (other.isSetProperty()) {
      this.property = new WeaponPropertyValue(other.property);
    }
  }

  public WeaponProperty deepCopy() {
    return new WeaponProperty(this);
  }

  @Override
  public void clear() {
    this.weapon = null;
    this.property = null;
  }

  public WeaponID getWeapon() {
    return this.weapon;
  }

  public WeaponProperty setWeapon(WeaponID weapon) {
    this.weapon = weapon;
    return this;
  }

  public void unsetWeapon() {
    this.weapon = null;
  }

  /** Returns true if field weapon is set (has been assigned a value) and false otherwise */
  public boolean isSetWeapon() {
    return this.weapon != null;
  }

  public void setWeaponIsSet(boolean value) {
    if (!value) {
      this.weapon = null;
    }
  }

  public WeaponPropertyValue getProperty() {
    return this.property;
  }

  public WeaponProperty setProperty(WeaponPropertyValue property) {
    this.property = property;
    return this;
  }

  public void unsetProperty() {
    this.property = null;
  }

  /** Returns true if field property is set (has been assigned a value) and false otherwise */
  public boolean isSetProperty() {
    return this.property != null;
  }

  public void setPropertyIsSet(boolean value) {
    if (!value) {
      this.property = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case WEAPON:
      if (value == null) {
        unsetWeapon();
      } else {
        setWeapon((WeaponID)value);
      }
      break;

    case PROPERTY:
      if (value == null) {
        unsetProperty();
      } else {
        setProperty((WeaponPropertyValue)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case WEAPON:
      return getWeapon();

    case PROPERTY:
      return getProperty();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case WEAPON:
      return isSetWeapon();
    case PROPERTY:
      return isSetProperty();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof WeaponProperty)
      return this.equals((WeaponProperty)that);
    return false;
  }

  public boolean equals(WeaponProperty that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_weapon = true && this.isSetWeapon();
    boolean that_present_weapon = true && that.isSetWeapon();
    if (this_present_weapon || that_present_weapon) {
      if (!(this_present_weapon && that_present_weapon))
        return false;
      if (!this.weapon.equals(that.weapon))
        return false;
    }

    boolean this_present_property = true && this.isSetProperty();
    boolean that_present_property = true && that.isSetProperty();
    if (this_present_property || that_present_property) {
      if (!(this_present_property && that_present_property))
        return false;
      if (!this.property.equals(that.property))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetWeapon()) ? 131071 : 524287);
    if (isSetWeapon())
      hashCode = hashCode * 8191 + weapon.hashCode();

    hashCode = hashCode * 8191 + ((isSetProperty()) ? 131071 : 524287);
    if (isSetProperty())
      hashCode = hashCode * 8191 + property.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(WeaponProperty other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetWeapon()).compareTo(other.isSetWeapon());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetWeapon()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.weapon, other.weapon);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetProperty()).compareTo(other.isSetProperty());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetProperty()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.property, other.property);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("WeaponProperty(");
    boolean first = true;

    sb.append("weapon:");
    if (this.weapon == null) {
      sb.append("null");
    } else {
      sb.append(this.weapon);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("property:");
    if (this.property == null) {
      sb.append("null");
    } else {
      sb.append(this.property);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (weapon == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'weapon' was not present! Struct: " + toString());
    }
    if (property == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'property' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class WeaponPropertyStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public WeaponPropertyStandardScheme getScheme() {
      return new WeaponPropertyStandardScheme();
    }
  }

  private static class WeaponPropertyStandardScheme extends org.apache.thrift.scheme.StandardScheme<WeaponProperty> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, WeaponProperty struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // WEAPON
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.weapon = new WeaponID();
              struct.weapon.read(iprot);
              struct.setWeaponIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PROPERTY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.property = new WeaponPropertyValue();
              struct.property.read(iprot);
              struct.setPropertyIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, WeaponProperty struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.weapon != null) {
        oprot.writeFieldBegin(WEAPON_FIELD_DESC);
        struct.weapon.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.property != null) {
        oprot.writeFieldBegin(PROPERTY_FIELD_DESC);
        struct.property.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class WeaponPropertyTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public WeaponPropertyTupleScheme getScheme() {
      return new WeaponPropertyTupleScheme();
    }
  }

  private static class WeaponPropertyTupleScheme extends org.apache.thrift.scheme.TupleScheme<WeaponProperty> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, WeaponProperty struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.weapon.write(oprot);
      struct.property.write(oprot);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, WeaponProperty struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.weapon = new WeaponID();
      struct.weapon.read(iprot);
      struct.setWeaponIsSet(true);
      struct.property = new WeaponPropertyValue();
      struct.property.read(iprot);
      struct.setPropertyIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

