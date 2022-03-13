package com.s8.io.bohr.neodymium.fields;

import com.s8.io.bohr.atom.S8Object;
import com.s8.io.bohr.neodymium.exceptions.NdIOException;
import com.s8.io.bohr.neodymium.type.BuildScope;
import com.s8.io.bytes.alpha.MemoryFootprint;


/**
 * <p><code>NdFieldDelta</code> are immutable!</p>
 * @author pierreconvert
 *
 */
public abstract class NdFieldDelta {
		
	
	public NdFieldDelta() {
		super();
	}
	
	/**
	 * 
	 * @param object
	 * @throws LthSerialException 
	 */
	public abstract void consume(S8Object object, BuildScope scope) throws NdIOException;
	
	public abstract void computeFootprint(MemoryFootprint weight);
	
	
	public abstract NdField getField();
}
