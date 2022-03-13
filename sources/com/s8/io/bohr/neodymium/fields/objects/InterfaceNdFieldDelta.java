package com.s8.io.bohr.neodymium.fields.objects;

import com.s8.io.bohr.atom.S8Index;
import com.s8.io.bohr.atom.S8Object;
import com.s8.io.bohr.neodymium.exceptions.NdIOException;
import com.s8.io.bohr.neodymium.fields.NdField;
import com.s8.io.bohr.neodymium.fields.NdFieldDelta;
import com.s8.io.bohr.neodymium.type.BuildScope;
import com.s8.io.bohr.neodymium.type.BuildScope.Binding;
import com.s8.io.bytes.alpha.MemoryFootprint;


/**
 * 
 * @author pc
 *
 */
public class InterfaceNdFieldDelta extends NdFieldDelta {

	public final InterfaceNdField field;

	public final S8Index index;

	/**
	 * 
	 * @param fieldCode
	 * @param field
	 * @param index
	 */
	public InterfaceNdFieldDelta(InterfaceNdField field, S8Index index) {
		super();
		this.field = field;
		this.index = index;
	}


	@Override
	public void consume(S8Object object, BuildScope scope) throws NdIOException {

		if(index != null) {
			scope.appendBinding(new Binding() {

				@Override
				public void resolve(BuildScope scope) throws NdIOException {
					S8Object struct = scope.retrieveObject(index);
					if(struct==null) {
						throw new NdIOException("Failed to retriev vertex");
					}
					field.handler.set(object, struct);
				}
			});
		}
		else {
			// nothing to do
			field.handler.set(object, null);
		}
	}

	public @Override NdField getField() { return field; }

	@Override
	public void computeFootprint(MemoryFootprint weight) {
		weight.reportReference();
	}
}
