/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.politecnica.bigdata.batchlayer.model;

@SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
public class AttackPropertyValue extends org.apache.thrift.TUnion<AttackPropertyValue, AttackPropertyValue._Fields> {
	private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct(
			"AttackPropertyValue");
	private static final org.apache.thrift.protocol.TField DATE_FIELD_DESC = new org.apache.thrift.protocol.TField(
			"date", org.apache.thrift.protocol.TType.STRUCT, (short) 1);
	private static final org.apache.thrift.protocol.TField COORDINATES_FIELD_DESC = new org.apache.thrift.protocol.TField(
			"coordinates", org.apache.thrift.protocol.TType.STRUCT, (short) 2);
	private static final org.apache.thrift.protocol.TField NKILLS_FIELD_DESC = new org.apache.thrift.protocol.TField(
			"nkills", org.apache.thrift.protocol.TType.I64, (short) 3);

	/**
	 * The set of fields this struct contains, along with convenience methods for
	 * finding and manipulating them.
	 */
	public enum _Fields implements org.apache.thrift.TFieldIdEnum {
		DATE((short) 1, "date"), COORDINATES((short) 2, "coordinates"), NKILLS((short) 3, "nkills");

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
			case 1: // DATE
				return DATE;
			case 2: // COORDINATES
				return COORDINATES;
			case 3: // NKILLS
				return NKILLS;
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
		tmpMap.put(_Fields.DATE, new org.apache.thrift.meta_data.FieldMetaData("date",
				org.apache.thrift.TFieldRequirementType.OPTIONAL,
				new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT, "Date")));
		tmpMap.put(_Fields.COORDINATES,
				new org.apache.thrift.meta_data.FieldMetaData("coordinates",
						org.apache.thrift.TFieldRequirementType.OPTIONAL,
						new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT,
								"Coordinates")));
		tmpMap.put(_Fields.NKILLS,
				new org.apache.thrift.meta_data.FieldMetaData("nkills",
						org.apache.thrift.TFieldRequirementType.OPTIONAL,
						new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
		metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
		org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(AttackPropertyValue.class, metaDataMap);
	}

	public AttackPropertyValue() {
		super();
	}

	public AttackPropertyValue(_Fields setField, java.lang.Object value) {
		super(setField, value);
	}

	public AttackPropertyValue(AttackPropertyValue other) {
		super(other);
	}

	public AttackPropertyValue deepCopy() {
		return new AttackPropertyValue(this);
	}

	public static AttackPropertyValue date(Date value) {
		AttackPropertyValue x = new AttackPropertyValue();
		x.setDate(value);
		return x;
	}

	public static AttackPropertyValue coordinates(Coordinates value) {
		AttackPropertyValue x = new AttackPropertyValue();
		x.setCoordinates(value);
		return x;
	}

	public static AttackPropertyValue nkills(long value) {
		AttackPropertyValue x = new AttackPropertyValue();
		x.setNkills(value);
		return x;
	}

	@Override
	protected void checkType(_Fields setField, java.lang.Object value) throws java.lang.ClassCastException {
		switch (setField) {
		case DATE:
			if (value instanceof Date) {
				break;
			}
			throw new java.lang.ClassCastException(
					"Was expecting value of type Date for field 'date', but got " + value.getClass().getSimpleName());
		case COORDINATES:
			if (value instanceof Coordinates) {
				break;
			}
			throw new java.lang.ClassCastException(
					"Was expecting value of type Coordinates for field 'coordinates', but got "
							+ value.getClass().getSimpleName());
		case NKILLS:
			if (value instanceof java.lang.Long) {
				break;
			}
			throw new java.lang.ClassCastException(
					"Was expecting value of type java.lang.Long for field 'nkills', but got "
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
			case DATE:
				if (field.type == DATE_FIELD_DESC.type) {
					Date date;
					date = new Date();
					date.read(iprot);
					return date;
				} else {
					org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
					return null;
				}
			case COORDINATES:
				if (field.type == COORDINATES_FIELD_DESC.type) {
					Coordinates coordinates;
					coordinates = new Coordinates();
					coordinates.read(iprot);
					return coordinates;
				} else {
					org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
					return null;
				}
			case NKILLS:
				if (field.type == NKILLS_FIELD_DESC.type) {
					java.lang.Long nkills;
					nkills = iprot.readI64();
					return nkills;
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
		case DATE:
			Date date = (Date) value_;
			date.write(oprot);
			return;
		case COORDINATES:
			Coordinates coordinates = (Coordinates) value_;
			coordinates.write(oprot);
			return;
		case NKILLS:
			java.lang.Long nkills = (java.lang.Long) value_;
			oprot.writeI64(nkills);
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
			case DATE:
				Date date;
				date = new Date();
				date.read(iprot);
				return date;
			case COORDINATES:
				Coordinates coordinates;
				coordinates = new Coordinates();
				coordinates.read(iprot);
				return coordinates;
			case NKILLS:
				java.lang.Long nkills;
				nkills = iprot.readI64();
				return nkills;
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
		case DATE:
			Date date = (Date) value_;
			date.write(oprot);
			return;
		case COORDINATES:
			Coordinates coordinates = (Coordinates) value_;
			coordinates.write(oprot);
			return;
		case NKILLS:
			java.lang.Long nkills = (java.lang.Long) value_;
			oprot.writeI64(nkills);
			return;
		default:
			throw new java.lang.IllegalStateException("Cannot write union with unknown field " + setField_);
		}
	}

	@Override
	protected org.apache.thrift.protocol.TField getFieldDesc(_Fields setField) {
		switch (setField) {
		case DATE:
			return DATE_FIELD_DESC;
		case COORDINATES:
			return COORDINATES_FIELD_DESC;
		case NKILLS:
			return NKILLS_FIELD_DESC;
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

	public Date getDate() {
		if (getSetField() == _Fields.DATE) {
			return (Date) getFieldValue();
		} else {
			throw new java.lang.RuntimeException(
					"Cannot get field 'date' because union is currently set to " + getFieldDesc(getSetField()).name);
		}
	}

	public void setDate(Date value) {
		if (value == null)
			throw new java.lang.NullPointerException();
		setField_ = _Fields.DATE;
		value_ = value;
	}

	public Coordinates getCoordinates() {
		if (getSetField() == _Fields.COORDINATES) {
			return (Coordinates) getFieldValue();
		} else {
			throw new java.lang.RuntimeException("Cannot get field 'coordinates' because union is currently set to "
					+ getFieldDesc(getSetField()).name);
		}
	}

	public void setCoordinates(Coordinates value) {
		if (value == null)
			throw new java.lang.NullPointerException();
		setField_ = _Fields.COORDINATES;
		value_ = value;
	}

	public long getNkills() {
		if (getSetField() == _Fields.NKILLS) {
			return (java.lang.Long) getFieldValue();
		} else {
			throw new java.lang.RuntimeException(
					"Cannot get field 'nkills' because union is currently set to " + getFieldDesc(getSetField()).name);
		}
	}

	public void setNkills(long value) {
		setField_ = _Fields.NKILLS;
		value_ = value;
	}

	public boolean isSetDate() {
		return setField_ == _Fields.DATE;
	}

	public boolean isSetCoordinates() {
		return setField_ == _Fields.COORDINATES;
	}

	public boolean isSetNkills() {
		return setField_ == _Fields.NKILLS;
	}

	public boolean equals(java.lang.Object other) {
		if (other instanceof AttackPropertyValue) {
			return equals((AttackPropertyValue) other);
		} else {
			return false;
		}
	}

	public boolean equals(AttackPropertyValue other) {
		return other != null && getSetField() == other.getSetField() && getFieldValue().equals(other.getFieldValue());
	}

	@Override
	public int compareTo(AttackPropertyValue other) {
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
