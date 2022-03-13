package com.s8.io.bohr.neodymium.properties;

import com.s8.io.bohr.neodymium.fields.EmbeddedTypeNature;
import com.s8.io.bohr.neodymium.fields.NdFieldPrototype;

public class NdFieldProperties1T extends NdFieldProperties {

	private final Class<?> baseType;
	

	public NdFieldProperties1T(NdFieldPrototype prototype, int mode, Class<?> baseType) {
		super(prototype, mode);
		this.baseType = baseType;
	}

	@Override
	public EmbeddedTypeNature getEmbeddedTypeNature() {
		return EmbeddedTypeNature.S8_OBJECT;
	}

	@Override
	public Class<?> getEmbeddedType() {
		return baseType;
	}

	@Override
	public Class<?> getBaseType() {
		return baseType;
	}

	@Override
	public Class<?> getParameterType1() {
		return null;
	}

	@Override
	public Class<?> getParameterType2() {
		return null;
	}

}
