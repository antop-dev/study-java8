package ch02;

import java.io.FileReader;
import java.util.List;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvToBeanBuilder;

public class Ex13 {

	public static void main(String[] args) throws Exception {
		FileReader reader = new FileReader("docs/ch02/dump.csv");
		List<OsCpu> beans = new CsvToBeanBuilder<OsCpu>(reader).withType(OsCpu.class).build().parse();
		for (OsCpu bean : beans) {
			System.out.println(bean);
		}
	}

	public static class OsCpu {
		@CsvBindByPosition(position = 0)
		private String svrYmdhms;
		@CsvBindByPosition(position = 1)
		private String sstmId;
		@CsvBindByPosition(position = 2)
		private String instId;
		@CsvBindByPosition(position = 3)
		private Integer type;
		@CsvBindByPosition(position = 4)
		private Integer subtype;
		@CsvBindByPosition(position = 5)
		private Integer serialnr;
		@CsvBindByPosition(position = 6)
		private Integer nbrCpu;
		@CsvBindByPosition(position = 7)
		private Integer load1Avg;
		@CsvBindByPosition(position = 8)
		private Integer load5Avg;
		@CsvBindByPosition(position = 9)
		private Integer load15Avg;
		@CsvBindByPosition(position = 10)
		private Integer intSec;
		@CsvBindByPosition(position = 11)
		private Integer syscSec;
		@CsvBindByPosition(position = 12)
		private Integer csSec;
		@CsvBindByPosition(position = 13)
		private Integer usrTotal;
		@CsvBindByPosition(position = 14)
		private Integer sysTotal;
		@CsvBindByPosition(position = 15)
		private Integer idleTotal;
		@CsvBindByPosition(position = 16)
		private Integer idleTrue;
		@CsvBindByPosition(position = 17)
		private Integer waitTrue;

		public String getSvrYmdhms() {
			return svrYmdhms;
		}

		public void setSvrYmdhms(String svrYmdhms) {
			this.svrYmdhms = svrYmdhms;
		}

		public String getSstmId() {
			return sstmId;
		}

		public void setSstmId(String sstmId) {
			this.sstmId = sstmId;
		}

		public String getInstId() {
			return instId;
		}

		public void setInstId(String instId) {
			this.instId = instId;
		}

		public Integer getType() {
			return type;
		}

		public void setType(Integer type) {
			this.type = type;
		}

		public Integer getSubtype() {
			return subtype;
		}

		public void setSubtype(Integer subtype) {
			this.subtype = subtype;
		}

		public Integer getSerialnr() {
			return serialnr;
		}

		public void setSerialnr(Integer serialnr) {
			this.serialnr = serialnr;
		}

		public Integer getNbrCpu() {
			return nbrCpu;
		}

		public void setNbrCpu(Integer nbrCpu) {
			this.nbrCpu = nbrCpu;
		}

		public Integer getLoad1Avg() {
			return load1Avg;
		}

		public void setLoad1Avg(Integer load1Avg) {
			this.load1Avg = load1Avg;
		}

		public Integer getLoad5Avg() {
			return load5Avg;
		}

		public void setLoad5Avg(Integer load5Avg) {
			this.load5Avg = load5Avg;
		}

		public Integer getLoad15Avg() {
			return load15Avg;
		}

		public void setLoad15Avg(Integer load15Avg) {
			this.load15Avg = load15Avg;
		}

		public Integer getIntSec() {
			return intSec;
		}

		public void setIntSec(Integer intSec) {
			this.intSec = intSec;
		}

		public Integer getSyscSec() {
			return syscSec;
		}

		public void setSyscSec(Integer syscSec) {
			this.syscSec = syscSec;
		}

		public Integer getCsSec() {
			return csSec;
		}

		public void setCsSec(Integer csSec) {
			this.csSec = csSec;
		}

		public Integer getUsrTotal() {
			return usrTotal;
		}

		public void setUsrTotal(Integer usrTotal) {
			this.usrTotal = usrTotal;
		}

		public Integer getSysTotal() {
			return sysTotal;
		}

		public void setSysTotal(Integer sysTotal) {
			this.sysTotal = sysTotal;
		}

		public Integer getIdleTotal() {
			return idleTotal;
		}

		public void setIdleTotal(Integer idleTotal) {
			this.idleTotal = idleTotal;
		}

		public Integer getIdleTrue() {
			return idleTrue;
		}

		public void setIdleTrue(Integer idleTrue) {
			this.idleTrue = idleTrue;
		}

		public Integer getWaitTrue() {
			return waitTrue;
		}

		public void setWaitTrue(Integer waitTrue) {
			this.waitTrue = waitTrue;
		}

		@Override
		public String toString() {
			return "OsCpu [svrYmdhms=" + svrYmdhms + ", sstmId=" + sstmId + ", instId=" + instId + ", type=" + type
					+ ", subtype=" + subtype + ", serialnr=" + serialnr + ", nbrCpu=" + nbrCpu + ", load1Avg=" + load1Avg
					+ ", load5Avg=" + load5Avg + ", load15Avg=" + load15Avg + ", intSec=" + intSec + ", syscSec=" + syscSec
					+ ", csSec=" + csSec + ", usrTotal=" + usrTotal + ", sysTotal=" + sysTotal + ", idleTotal=" + idleTotal
					+ ", idleTrue=" + idleTrue + ", waitTrue=" + waitTrue + "]";
		}

	}
}
