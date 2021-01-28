package edu.vo;

public interface LaguageType{
	
	enum EXECUTION_SITE{CLIENT,SERVER,SHELL}
	enum TYPE_SYSTEM{STATIC,DYNAMIC,NA}
	enum PARADIGM{PROCEDURAL,OBJECT_ORIENTED,FUNCTIONAL,SCRIPTING;
		boolean isA(String name) {
			return PARADIGM.valueOf(name).name().equals(name);
		}
		boolean isA(PARADIGM name) {
			return this.equals(name);
		}
		
	}
	
	enum ECOSYSTEM{JVM,DOT_NET,BATCH,DB,OTHER}

}
