package com.s8.io.bohr.neodymium.fields.objects;

import com.s8.io.bohr.atom.S8Object;
import com.s8.io.bohr.atom.S8Table;
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
public class S8TableNdFieldDelta extends NdFieldDelta {


	public final S8TableNdField field;

	
	public S8Table<?> table;


	/**
	 * 
	 * @param fieldCode
	 * @param field
	 * @param value
	 */
	public S8TableNdFieldDelta(S8TableNdField field, S8Table<?> table) {
		super();
		this.field = field;
		this.table = table;
	}



	@Override
	public void consume(S8Object object, BuildScope scope) throws NdIOException {
		field.handler.set(object, table);
	}


	@Override
	public NdField getField() { 
		return field;
	}

	
	@Override
	public void computeFootprint(MemoryFootprint weight) {
		weight.reportBytes(1 + table.address.length() + 8);
	}

}
