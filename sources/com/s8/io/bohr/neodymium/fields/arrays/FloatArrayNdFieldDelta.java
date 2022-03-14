package com.s8.io.bohr.neodymium.fields.arrays;

import com.s8.io.bohr.atom.S8Object;
import com.s8.io.bohr.neodymium.exceptions.NdIOException;
import com.s8.io.bohr.neodymium.fields.NdField;
import com.s8.io.bohr.neodymium.fields.NdFieldDelta;
import com.s8.io.bohr.neodymium.type.BuildScope;
import com.s8.io.bytes.alpha.MemoryFootprint;



/**
 * 
 *
 * @author Pierre Convert
 * Copyright (C) 2022, Pierre Convert. All rights reserved.
 * 
 */
public class FloatArrayNdFieldDelta extends NdFieldDelta {

	
	public final FloatArrayNdField field;
	
	public final float[] value;

	public FloatArrayNdFieldDelta(FloatArrayNdField field, float[] array) {
		super();
		this.field = field;
		this.value = array;
	}

	@Override
	public NdField getField() {
		return field;
	}

	@Override
	public void consume(S8Object object, BuildScope scope) throws NdIOException {
		field.handler.set(object, value);
	}	

	@Override
	public void computeFootprint(MemoryFootprint weight) {
		if(value!=null) {
			weight.reportInstance();
			weight.reportBytes(value.length*4);
		}
	}


}