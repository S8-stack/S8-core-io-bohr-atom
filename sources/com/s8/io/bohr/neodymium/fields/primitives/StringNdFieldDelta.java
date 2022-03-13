package com.s8.io.bohr.neodymium.fields.primitives;

import com.s8.io.bohr.atom.S8Object;
import com.s8.io.bohr.neodymium.exceptions.NdIOException;
import com.s8.io.bohr.neodymium.fields.NdFieldDelta;
import com.s8.io.bohr.neodymium.type.BuildScope;
import com.s8.io.bytes.alpha.MemoryFootprint;


/**
 * 
 * @author pierreconvert
 *
 */
public class StringNdFieldDelta extends NdFieldDelta {


	public final StringNdField field;

	public final String value;

	public StringNdFieldDelta(StringNdField field, String value) {
		super();
		this.field = field;
		this.value = value;
	}

	@Override 
	public StringNdField getField() { 
		return field;
	}


	@Override
	public void consume(S8Object object, BuildScope scope) throws NdIOException {
		field.handler.setString(object, value);
	}

	@Override
	public void computeFootprint(MemoryFootprint weight) {
		if(value!=null) {
			weight.reportInstance();
			weight.reportBytes(value.length());
		}
	}

}
