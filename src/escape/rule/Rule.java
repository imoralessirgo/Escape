/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Copyright ©2016 Gary F. Pollice
 *******************************************************************************/

package escape.rule;

/**
 * Rule Class
 * @version May 8, 2020
 */
public class Rule {
	RuleID id;
	int intValue;
	
	public Rule() {}
	

	public RuleID getId() { return id; }
	
	
	public void setId(RuleID id) { this.id = id; }
	
	
	public int getIntValue() { return intValue; }
	

	public void setIntValue(int intValue) { this.intValue = intValue; }
	
}
