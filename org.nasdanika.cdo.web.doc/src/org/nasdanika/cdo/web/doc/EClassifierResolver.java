package org.nasdanika.cdo.web.doc;

import org.apache.commons.codec.binary.Hex;

public class EClassifierResolver implements WikiLinkResolver {

	@Override
	public String resolve(String spec, String docRoutePath) {
		int idx = spec.indexOf("@");
		if (idx==-1) {
			return spec;			
		}
		return "../"+Hex.encodeHexString(spec.substring(idx+1).trim().getBytes(/* UTF-8? */))+"/"+spec.substring(0, idx).trim();
	}

}
