package edu.vo;

import static edu.vo.LaguageType.ECOSYSTEM.BATCH;
import static edu.vo.LaguageType.ECOSYSTEM.DB;
import static edu.vo.LaguageType.ECOSYSTEM.DOT_NET;
import static edu.vo.LaguageType.ECOSYSTEM.JVM;
import static edu.vo.LaguageType.ECOSYSTEM.OTHER;
import static edu.vo.LaguageType.EXECUTION_SITE.CLIENT;
import static edu.vo.LaguageType.EXECUTION_SITE.SERVER;
import static edu.vo.LaguageType.EXECUTION_SITE.SHELL;
import static edu.vo.LaguageType.PARADIGM.FUNCTIONAL;
import static edu.vo.LaguageType.PARADIGM.OBJECT_ORIENTED;
import static edu.vo.LaguageType.PARADIGM.PROCEDURAL;
import static edu.vo.LaguageType.PARADIGM.SCRIPTING;
import static edu.vo.LaguageType.TYPE_SYSTEM.DYNAMIC;
import static edu.vo.LaguageType.TYPE_SYSTEM.NA;
import static edu.vo.LaguageType.TYPE_SYSTEM.STATIC;
import static java.lang.String.valueOf;
import static java.time.LocalDate.now;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.rightPad;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import edu.vo.LaguageType.ECOSYSTEM;
import edu.vo.LaguageType.EXECUTION_SITE;
import edu.vo.LaguageType.PARADIGM;
import edu.vo.LaguageType.TYPE_SYSTEM;


public class Language{
		private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		public Language(String _name,String _dob,EXECUTION_SITE _executionSite,TYPE_SYSTEM _typeSystem,PARADIGM _paradigm,ECOSYSTEM _ecosystem) {
				this.name=_name;
				this.dob = LocalDate.parse(_dob, dateFormatter);
				this.executionSite=_executionSite;
				this.typeSystem=_typeSystem;
				this.programParadigm=_paradigm;
				this.ecosystem=_ecosystem;
			}
		
		private String name;
		private LocalDate dob;
		private EXECUTION_SITE executionSite;
		private TYPE_SYSTEM typeSystem;
		private PARADIGM programParadigm;
		private ECOSYSTEM ecosystem;
		
		public int getAge() {
			return Period.between(dob, now()).getYears();
		}
	
		public String getName() { return name;}
		public LocalDate getDob() {return dob;}
		public EXECUTION_SITE getExecutionSite() {return executionSite;}
		public TYPE_SYSTEM getTypeSystem() {return typeSystem;}
		public PARADIGM getProgramParadigm() {return programParadigm;}
		public ECOSYSTEM getEcosystem() {return ecosystem;}
	
		public static List<Language> listOfLanguages(){
			return new ArrayList<Language>(
					asList(
							new Language("Java"       , "1995-05-23", SERVER            , STATIC    , OBJECT_ORIENTED , JVM     ),
							new Language("Scala"      , "2004-01-01", SERVER            , STATIC    , FUNCTIONAL      , JVM     ),
							new Language("Groovy"     , "2003-01-01", SERVER            , DYNAMIC   , OBJECT_ORIENTED , JVM     ),
							new Language("Python"     , "1990-01-01", SERVER            , DYNAMIC   , FUNCTIONAL      , OTHER   ),
							new Language("Bash"       , "1989-01-01", SHELL 			, NA        , PROCEDURAL      , BATCH   ),
							new Language("Ksh"        , "1983-01-01", SHELL 			, NA        , PROCEDURAL      , BATCH   ),
							new Language("Perl"       , "1987-01-01", SHELL 			, DYNAMIC   , OBJECT_ORIENTED , BATCH   ),
							new Language("Powershell" , "2006-01-01", SERVER            , DYNAMIC   , OBJECT_ORIENTED , BATCH   ),
							new Language("Ruby"       , "1995-01-01", SERVER            , DYNAMIC   , FUNCTIONAL      , OTHER   ),
							new Language("Javascript" , "1995-01-01", CLIENT            , DYNAMIC   , SCRIPTING       , OTHER   ),
							new Language("TypeScript" , "2012-01-01", CLIENT            , STATIC    , SCRIPTING       , OTHER   ),
							new Language("NodeJs"     , "2009-01-01", SERVER            , DYNAMIC   , SCRIPTING       , OTHER   ),
							new Language("Sed"        , "1974-01-01", SHELL 			, NA        , SCRIPTING       , BATCH   ),
							new Language("Awk"        , "1977-01-01", SHELL 			, NA        , SCRIPTING       , BATCH   ),
							new Language("C++"        , "1985-01-01", SERVER            , STATIC    , OBJECT_ORIENTED , OTHER   ),
							new Language("C"          , "1972-01-01", SERVER            , STATIC    , PROCEDURAL      , OTHER   ),
							new Language("Haskell"    , "1990-01-01", SERVER            , STATIC    , FUNCTIONAL      , OTHER   ),
							new Language("Kotlin"     , "2011-01-01", SERVER            , STATIC    , OBJECT_ORIENTED , JVM     ),
							new Language("C#"         , "2000-01-01", SERVER            , STATIC    , OBJECT_ORIENTED , DOT_NET ),
							new Language("SAS"        , "1976-01-01", SERVER            , NA        , PROCEDURAL      , DB      ),
							new Language("SQL"        , "1974-01-01", SERVER            , NA        , PROCEDURAL      , DB      )
							)
					);
		}


		public String toString() {
			return rightPad(name, 11,"-")+">"
					+ " age="+rightPad(valueOf(getAge()),2)
					+", Site=" + rightPad(executionSite.name(),7)
					+ ", type=" + rightPad(typeSystem.name(),7)
					+ ", Paradigm=" + rightPad(programParadigm.name(),16)
					+ ", ecosystem=" + rightPad(ecosystem.name(),6)
					;
			
		}

}
