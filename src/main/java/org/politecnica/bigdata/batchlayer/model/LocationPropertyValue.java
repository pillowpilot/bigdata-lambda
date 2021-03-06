/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.politecnica.bigdata.batchlayer.model;

@SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
public class LocationPropertyValue
		extends org.apache.thrift.TUnion<LocationPropertyValue, LocationPropertyValue._Fields> {
	private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct(
			"LocationPropertyValue");
	private static final org.apache.thrift.protocol.TField CITY_FIELD_DESC = new org.apache.thrift.protocol.TField(
			"city", org.apache.thrift.protocol.TType.STRING, (short) 1);
	private static final org.apache.thrift.protocol.TField COUNTRY_FIELD_DESC = new org.apache.thrift.protocol.TField(
			"country", org.apache.thrift.protocol.TType.STRING, (short) 2);
	private static final org.apache.thrift.protocol.TField REGION_FIELD_DESC = new org.apache.thrift.protocol.TField(
			"region", org.apache.thrift.protocol.TType.STRING, (short) 3);

	/**
	 * The set of fields this struct contains, along with convenience methods for
	 * finding and manipulating them.
	 */
	public enum _Fields implements org.apache.thrift.TFieldIdEnum {
		CITY((short) 1, "city"), COUNTRY((short) 2, "country"), REGION((short) 3, "region");

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
			switch (fieldId) {
			case 1: // CITY
				return CITY;
			case 2: // COUNTRY
				return COUNTRY;
			case 3: // REGION
				return REGION;
			default:
				return null;
			}
		}

		/**
		 * Find the _Fields constant that matches fieldId, throwing an exception if it
		 * is not found.
		 */
		public static _Fields findByThriftIdOrThrow(int fieldId) {
			_Fields fields = findByThriftId(fieldId);
			if (fields == null)
				throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
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

	public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
	static {
		java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(
				_Fields.class);
		tmpMap.put(_Fields.CITY,
				new org.apache.thrift.meta_data.FieldMetaData("city", org.apache.thrift.TFieldRequirementType.OPTIONAL,
						new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
		tmpMap.put(_Fields.COUNTRY,
				new org.apache.thrift.meta_data.FieldMetaData("country",
						org.apache.thrift.TFieldRequirementType.OPTIONAL,
						new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
		tmpMap.put(_Fields.REGION,
				new org.apache.thrift.meta_data.FieldMetaData("region",
						org.apache.thrift.TFieldRequirementType.OPTIONAL,
						new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
		metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
		org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(LocationPropertyValue.class, metaDataMap);
	}

	public LocationPropertyValue() {
		super();
	}

	public LocationPropertyValue(_Fields setField, java.lang.Object value) {
		super(setField, value);
	}

	public LocationPropertyValue(LocationPropertyValue other) {
		super(other);
	}

	public LocationPropertyValue deepCopy() {
		return new LocationPropertyValue(this);
	}

	public static LocationPropertyValue city(java.lang.String value) {
		LocationPropertyValue x = new LocationPropertyValue();
		x.setCity(value);
		return x;
	}

	public static LocationPropertyValue country(java.lang.String value) {
		LocationPropertyValue x = new LocationPropertyValue();
		x.setCountry(value);
		return x;
	}

	public static LocationPropertyValue region(java.lang.String value) {
		LocationPropertyValue x = new LocationPropertyValue();
		x.setRegion(value);
		return x;
	}

	@Override
	protected void checkType(_Fields setField, java.lang.Object value) throws java.lang.ClassCastException {
		switch (setField) {
		case CITY:
			if (value instanceof java.lang.String) {
				break;
			}
			throw new java.lang.ClassCastException(
					"Was expecting value of type java.lang.String for field 'city', but got "
							+ value.getClass().getSimpleName());
		case COUNTRY:
			if (value instanceof java.lang.String) {
				break;
			}
			throw new java.lang.ClassCastException(
					"Was expecting value of type java.lang.String for field 'country', but got "
							+ value.getClass().getSimpleName());
		case REGION:
			if (value instanceof java.lang.String) {
				break;
			}
			throw new java.lang.ClassCastException(
					"Was expecting value of type java.lang.String for field 'region', but got "
							+ value.getClass().getSimpleName());
		default:
			throw new java.lang.IllegalArgumentException("Unknown field id " + setField);
		}
	}

	@Override
	protected java.lang.Object standardSchemeReadValue(org.apache.thrift.protocol.TProtocol iprot,
			org.apache.thrift.protocol.TField field) throws org.apache.thrift.TException {
		_Fields setField = _Fields.findByThriftId(field.id);
		if (setField != null) {
			switch (setField) {
			case CITY:
				if (field.type == CITY_FIELD_DESC.type) {
					java.lang.String city;
					city = iprot.readString();
					return city;
				} else {
					org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
					return null;
				}
			case COUNTRY:
				if (field.type == COUNTRY_FIELD_DESC.type) {
					java.lang.String country;
					country = iprot.readString();
					return country;
				} else {
					org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
					return null;
				}
			case REGION:
				if (field.type == REGION_FIELD_DESC.type) {
					java.lang.String region;
					region = iprot.readString();
					return region;
				} else {
					org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
					return null;
				}
			default:
				throw new java.lang.IllegalStateException(
						"setField wasn't null, but didn't match any of the case statements!");
			}
		} else {
			org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
			return null;
		}
	}

	@Override
	protected void standardSchemeWriteValue(org.apache.thrift.protocol.TProtocol oprot)
			throws org.apache.thrift.TException {
		switch (setField_) {
		case CITY:
			java.lang.String city = (java.lang.String) value_;
			oprot.writeString(city);
			return;
		case COUNTRY:
			java.lang.String country = (java.lang.String) value_;
			oprot.writeString(country);
			return;
		case REGION:
			java.lang.String region = (java.lang.String) value_;
			oprot.writeString(region);
			return;
		default:
			throw new java.lang.IllegalStateException("Cannot write union with unknown field " + setField_);
		}
	}

	@Override
	protected java.lang.Object tupleSchemeReadValue(org.apache.thrift.protocol.TProtocol iprot, short fieldID)
			throws org.apache.thrift.TException {
		_Fields setField = _Fields.findByThriftId(fieldID);
		if (setField != null) {
			switch (setField) {
			case CITY:
				java.lang.String city;
				city = iprot.readString();
				return city;
			case COUNTRY:
				java.lang.String country;
				country = iprot.readString();
				return country;
			case REGION:
				java.lang.String region;
				region = iprot.readString();
				return region;
			default:
				throw new java.lang.IllegalStateException(
						"setField wasn't null, but didn't match any of the case statements!");
			}
		} else {
			throw new org.apache.thrift.protocol.TProtocolException("Couldn't find a field with field id " + fieldID);
		}
	}

	@Override
	protected void tupleSchemeWriteValue(org.apache.thrift.protocol.TProtocol oprot)
			throws org.apache.thrift.TException {
		switch (setField_) {
		case CITY:
			java.lang.String city = (java.lang.String) value_;
			oprot.writeString(city);
			return;
		case COUNTRY:
			java.lang.String country = (java.lang.String) value_;
			oprot.writeString(country);
			return;
		case REGION:
			java.lang.String region = (java.lang.String) value_;
			oprot.writeString(region);
			return;
		default:
			throw new java.lang.IllegalStateException("Cannot write union with unknown field " + setField_);
		}
	}

	@Override
	protected org.apache.thrift.protocol.TField getFieldDesc(_Fields setField) {
		switch (setField) {
		case CITY:
			return CITY_FIELD_DESC;
		case COUNTRY:
			return COUNTRY_FIELD_DESC;
		case REGION:
			return REGION_FIELD_DESC;
		default:
			throw new java.lang.IllegalArgumentException("Unknown field id " + setField);
		}
	}

	@Override
	protected org.apache.thrift.protocol.TStruct getStructDesc() {
		return STRUCT_DESC;
	}

	@Override
	protected _Fields enumForId(short id) {
		return _Fields.findByThriftIdOrThrow(id);
	}

	public _Fields fieldForId(int fieldId) {
		return _Fields.findByThriftId(fieldId);
	}

	public java.lang.String getCity() {
		if (getSetField() == _Fields.CITY) {
			return (java.lang.String) getFieldValue();
		} else {
			throw new java.lang.RuntimeException(
					"Cannot get field 'city' because union is currently set to " + getFieldDesc(getSetField()).name);
		}
	}

	public void setCity(java.lang.String value) {
		if (value == null)
			throw new java.lang.NullPointerException();
		setField_ = _Fields.CITY;
		value_ = value;
	}

	public java.lang.String getCountry() {
		if (getSetField() == _Fields.COUNTRY) {
			return (java.lang.String) getFieldValue();
		} else {
			throw new java.lang.RuntimeException(
					"Cannot get field 'country' because union is currently set to " + getFieldDesc(getSetField()).name);
		}
	}

	public void setCountry(java.lang.String value) {
		if (value == null)
			throw new java.lang.NullPointerException();
		setField_ = _Fields.COUNTRY;
		value_ = value;
	}

	public java.lang.String getRegion() {
		if (getSetField() == _Fields.REGION) {
			return (java.lang.String) getFieldValue();
		} else {
			throw new java.lang.RuntimeException(
					"Cannot get field 'region' because union is currently set to " + getFieldDesc(getSetField()).name);
		}
	}

	public void setRegion(java.lang.String value) {
		if (value == null)
			throw new java.lang.NullPointerException();
		setField_ = _Fields.REGION;
		value_ = value;
	}

	public boolean isSetCity() {
		return setField_ == _Fields.CITY;
	}

	public boolean isSetCountry() {
		return setField_ == _Fields.COUNTRY;
	}

	public boolean isSetRegion() {
		return setField_ == _Fields.REGION;
	}

	public boolean equals(java.lang.Object other) {
		if (other instanceof LocationPropertyValue) {
			return equals((LocationPropertyValue) other);
		} else {
			return false;
		}
	}

	public boolean equals(LocationPropertyValue other) {
		return other != null && getSetField() == other.getSetField() && getFieldValue().equals(other.getFieldValue());
	}

	@Override
	public int compareTo(LocationPropertyValue other) {
		int lastComparison = org.apache.thrift.TBaseHelper.compareTo(getSetField(), other.getSetField());
		if (lastComparison == 0) {
			return org.apache.thrift.TBaseHelper.compareTo(getFieldValue(), other.getFieldValue());
		}
		return lastComparison;
	}

	@Override
	public int hashCode() {
		java.util.List<java.lang.Object> list = new java.util.ArrayList<java.lang.Object>();
		list.add(this.getClass().getName());
		org.apache.thrift.TFieldIdEnum setField = getSetField();
		if (setField != null) {
			list.add(setField.getThriftFieldId());
			java.lang.Object value = getFieldValue();
			if (value instanceof org.apache.thrift.TEnum) {
				list.add(((org.apache.thrift.TEnum) getFieldValue()).getValue());
			} else {
				list.add(value);
			}
		}
		return list.hashCode();
	}

	private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
		try {
			write(new org.apache.thrift.protocol.TCompactProtocol(
					new org.apache.thrift.transport.TIOStreamTransport(out)));
		} catch (org.apache.thrift.TException te) {
			throw new java.io.IOException(te);
		}
	}

	private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
		try {
			read(new org.apache.thrift.protocol.TCompactProtocol(
					new org.apache.thrift.transport.TIOStreamTransport(in)));
		} catch (org.apache.thrift.TException te) {
			throw new java.io.IOException(te);
		}
	}

}
