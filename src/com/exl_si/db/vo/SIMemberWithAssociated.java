package com.exl_si.db.vo;

import com.exl_si.db.SIMember;
import com.exl_si.db.SIMemberFile;

public class SIMemberWithAssociated {
		private SIMember member;
		private SIMemberFile file;
		
		public SIMemberWithAssociated(SIMember member, SIMemberFile file) {
			this.member = member;
			this.file = file;
		}

		public SIMember getMember() {
			return member;
		}

		public void setMember(SIMember member) {
			this.member = member;
		}

		public SIMemberFile getFile() {
			return file;
		}

		public void setFile(SIMemberFile file) {
			this.file = file;
		}

}
