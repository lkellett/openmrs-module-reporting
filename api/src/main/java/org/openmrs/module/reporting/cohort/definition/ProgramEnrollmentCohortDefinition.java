package org.openmrs.module.reporting.cohort.definition;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openmrs.Program;
import org.openmrs.module.reporting.common.Localized;
import org.openmrs.module.reporting.definition.configuration.ConfigurationProperty;

/**
 * Query for whether the patient enrolled in or completed any of the specified programs in a date range
 */
@Localized("reporting.ProgramEnrollmentCohortDefinition")
public class ProgramEnrollmentCohortDefinition extends BaseCohortDefinition {

	public static final long serialVersionUID = 1L;
	
	@ConfigurationProperty(required=true, group="programsGroup")
	private List<Program> programs;
	
	@ConfigurationProperty(group="enrollmentDate")
	private Date enrolledOnOrAfter;

	@ConfigurationProperty(group="enrollmentDate")
	private Date enrolledOnOrBefore;

	@ConfigurationProperty(group="completionDate")
	private Date completedOnOrAfter;

	@ConfigurationProperty(group="completionDate")
	private Date completedOnOrBefore;
	
	/**
	 * Default constructor
	 */
	public ProgramEnrollmentCohortDefinition() { }

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder ret = new StringBuilder();
		ret.append("Patients ");
		if (enrolledOnOrAfter != null) {
			ret.append("who enrolled on or after " + enrolledOnOrAfter + " ");
		}
		if (enrolledOnOrBefore != null) {
			ret.append("who enrolled on or before " + enrolledOnOrBefore+ " ");
		}
		if (completedOnOrAfter != null) {
			ret.append("who completed on or after " + completedOnOrAfter + " ");
		}
		if (completedOnOrBefore != null) {
			ret.append("who completed on or before " + completedOnOrBefore + " ");
		}
			
		if (programs != null && programs.size() > 0) {
			ret.append(" in ");
			for (Program p : programs) {
				ret.append(p.getName() + " ");
			}
		}		
		return ret.toString();
	}
	
    /**
     * @return the programs
     */
    public List<Program> getPrograms() {
    	return programs;
    }

    /**
     * @param programs the programs to set
     */
    public void setPrograms(List<Program> programs) {
    	this.programs = programs;
    }
    
    /**
     * @param program the program to add
     */
    public void addProgram(Program program) {
    	if (programs == null) {
    		programs = new ArrayList<Program>();
    	}
    	programs.add(program);
    }
	
    /**
     * @return the enrolledOnOrAfter
     */
    public Date getEnrolledOnOrAfter() {
    	return enrolledOnOrAfter;
    }
	
    /**
     * @param enrolledOnOrAfter the enrolledOnOrAfter to set
     */
    public void setEnrolledOnOrAfter(Date enrolledOnOrAfter) {
    	this.enrolledOnOrAfter = enrolledOnOrAfter;
    }
	
    /**
     * @return the enrolledOnOrBefore
     */
    public Date getEnrolledOnOrBefore() {
    	return enrolledOnOrBefore;
    }
	
    /**
     * @param enrolledOnOrBefore the enrolledOnOrBefore to set
     */
    public void setEnrolledOnOrBefore(Date enrolledOnOrBefore) {
    	this.enrolledOnOrBefore = enrolledOnOrBefore;
    }
	
    /**
     * @return the completedOnOrAfter
     */
    public Date getCompletedOnOrAfter() {
    	return completedOnOrAfter;
    }

    /**
     * @param completedOnOrAfter the completedOnOrAfter to set
     */
    public void setCompletedOnOrAfter(Date completedOnOrAfter) {
    	this.completedOnOrAfter = completedOnOrAfter;
    }

    /**
     * @return the completedOnOrBefore
     */
    public Date getCompletedOnOrBefore() {
    	return completedOnOrBefore;
    }

    /**
     * @param completedOnOrBefore the completedOnOrBefore to set
     */
    public void setCompletedOnOrBefore(Date completedOnOrBefore) {
    	this.completedOnOrBefore = completedOnOrBefore;
    }    
}
