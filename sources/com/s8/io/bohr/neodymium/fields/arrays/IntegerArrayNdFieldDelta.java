package com.s8.io.bohr.neodymium.fields.arrays;

import com.s8.io.bohr.atom.S8Object;
import com.s8.io.bohr.neodymium.exceptions.NdIOException;
import com.s8.io.bohr.neodymium.fields.NdField;
import com.s8.io.bohr.neodymium.fields.NdFieldDelta;
import com.s8.io.bohr.neodymium.type.BuildScope;
import com.s8.io.bytes.alpha.MemoryFootprint;

/**
 * 
 * @author pc
 *
 */
public class IntegerArrayNdFieldDelta extends NdFieldDelta {

	
	public final IntegerArrayNdField field;

	public final int[] value;

	public IntegerArrayNdFieldDelta(IntegerArrayNdField field, int[] array) {
		super();
		this.field = field;
		this.value = array;
	}

	public @Override NdField getField() { return field; }

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
