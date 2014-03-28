package org.nasdanika.cdo.xa;

import java.util.Arrays;

import javax.transaction.xa.Xid;

/**
 * The spec doesn't stipulate that Xid implementations properly implement equals() and hashCode().
 * Using this class to be on the safe side.
 * @author Pavel Vlasov
 *
 */
class XidKey {
	
	private Xid xid;
	private byte[] branchQualifier;
	private int formatId;
	private byte[] globalTransactionId;

	public XidKey(Xid xid) {
		this.xid = xid;
		branchQualifier = xid.getBranchQualifier();
		formatId = xid.getFormatId();
		globalTransactionId = xid.getGlobalTransactionId();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(branchQualifier);
		result = prime * result + formatId;
		result = prime * result + Arrays.hashCode(globalTransactionId);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		XidKey other = (XidKey) obj;
		if (xid == other.xid) {
			return true;
		}
		if (xid.equals(other.xid)) {
			return true;
		}
		if (!Arrays.equals(branchQualifier, other.branchQualifier))
			return false;
		if (formatId != other.formatId)
			return false;
		if (!Arrays.equals(globalTransactionId, other.globalTransactionId))
			return false;
		return true;
	}
	
	public Xid getXid() {
		return xid;
	}

	@Override
	public String toString() {
		return "XidKey [xid=" + xid + ", branchQualifier="
				+ Arrays.toString(branchQualifier) + ", formatId=" + formatId
				+ ", globalTransactionId="
				+ Arrays.toString(globalTransactionId) + "]";
	}	
	
	
	
}