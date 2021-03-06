/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.reporting.data.person.evaluator;

import java.util.Map;

import org.openmrs.annotation.Handler;
import org.openmrs.api.context.Context;
import org.openmrs.module.reporting.data.converter.BirthdateToAgeConverter;
import org.openmrs.module.reporting.data.person.EvaluatedPersonData;
import org.openmrs.module.reporting.data.person.definition.AgeDataDefinition;
import org.openmrs.module.reporting.data.person.definition.BirthdateDataDefinition;
import org.openmrs.module.reporting.data.person.definition.PersonDataDefinition;
import org.openmrs.module.reporting.data.person.service.PersonDataService;
import org.openmrs.module.reporting.evaluation.EvaluationContext;
import org.openmrs.module.reporting.evaluation.EvaluationException;

/**
 * Evaluates a AgeDataDefinition to produce a PersonData
 */
@Handler(supports=AgeDataDefinition.class, order=50)
public class AgeDataEvaluator implements PersonDataEvaluator {

	/** 
	 * @see PersonDataEvaluator#evaluate(PersonDataDefinition, EvaluationContext)
	 * @should return all ages for the given context
	 */
	public EvaluatedPersonData evaluate(PersonDataDefinition definition, EvaluationContext context) throws EvaluationException {
		EvaluatedPersonData c = Context.getService(PersonDataService.class).evaluate(new BirthdateDataDefinition(), context);
		AgeDataDefinition add = (AgeDataDefinition)definition;
        BirthdateToAgeConverter converter = new BirthdateToAgeConverter(add.getEffectiveDate());
		EvaluatedPersonData ret = new EvaluatedPersonData(definition, context);
		for (Map.Entry<Integer, Object> e : c.getData().entrySet()) {
			ret.addData(e.getKey(), converter.convert(e.getValue()));
		}
		return ret;
	}
}
