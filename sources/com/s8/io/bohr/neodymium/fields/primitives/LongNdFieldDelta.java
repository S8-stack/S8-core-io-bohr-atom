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
public class LongNdFieldDelta extends NdFieldDelta {


	public final LongNdField field;

	public final long value;

	public LongNdFieldDelta(LongNdField field, long value) {
		super();
		this.field = field;
		this.value = value;
	}

	public @Override LongNdField getField() { return field; }

	@Override
	public void consume(S8Object object, BuildScope scope) throws NdIOException {
		field.handler.setLong(object, value);
	}

	@Override
	public void computeFootprint(MemoryFootprint weight) {
		weight.reportBytes(8);
	}
}

