/*
 * Copyright (C) 2010 - present, Laszlo Csontos
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

/**
 * 
 */
package info.geekinaction.autoalert.model.incident;

import info.geekinaction.autoalert.common.util.DateUtil;
import info.geekinaction.autoalert.model.domain.Database;
import info.geekinaction.autoalert.model.domain.Datafile;
import info.geekinaction.autoalert.model.domain.InstanceCpuUsage;
import info.geekinaction.autoalert.model.domain.InstanceIoUsage;
import info.geekinaction.autoalert.model.domain.Tablespace;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Represents a detected threshold violation and contains its details.
 * 
 * @author lcsontos
 * 
 */
@XmlRootElement(name = "incident")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class AutoAlertIncident implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	protected Database database;
	protected List<Tablespace> tablespaces;
	protected List<Datafile> datafiles;
	protected InstanceCpuUsage cpuUsage;
	protected InstanceIoUsage ioUsage;
	
	protected int checkSum = 0;
	protected Date timeDetected;
	protected String details = null;

	/**
	 * 
	 */
	public AutoAlertIncident() { 
		timeDetected = DateUtil.currentTime();
	}

	/**
	 * 
	 * @param tablespaces
	 * @param datafiles
	 * @param cpuUsage
	 * @param ioUsage
	 */
	public AutoAlertIncident(Database _database, List<Tablespace> tablespaces, List<Datafile> datafiles, InstanceCpuUsage cpuUsage, InstanceIoUsage ioUsage) {
		this();
		this.database = _database;
		this.tablespaces = tablespaces;
		this.datafiles = datafiles;
		this.cpuUsage = cpuUsage;
		this.ioUsage = ioUsage;
	}

	
	/**
	 * 
	 * @return
	 */
	@XmlAttribute(name = "id")
	public Long getId() {
		return id;
	}
	
	/**
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return
	 */
	@XmlTransient
	public Database getDatabase() {
		return database;
	}
	
	/**
	 * 
	 * @param database
	 */
	public void setDatabase(Database database) {
		this.database = database;
	}

	/**
	 * @return the tablespaces
	 */
	@XmlElementWrapper(name = "tablespaces")
	@XmlElement(name = "tablespace")
	public List<Tablespace> getTablespaces() {
		return tablespaces;
	}

	/**
	 * @param tablespaces
	 *            the tablespaces to set
	 */
	public void setTablespaces(List<Tablespace> tablespaces) {
		this.tablespaces = tablespaces;
		this.checkSum = 0;
		this.details = null;
	}

	/**
	 * @return the datafiles
	 */
	@XmlElementWrapper(name = "datafiles")
	@XmlElement(name = "datafile")
	public List<Datafile> getDatafiles() {
		return datafiles;
	}

	/**
	 * @param datafiles
	 *            the datafiles to set
	 */
	public void setDatafiles(List<Datafile> datafiles) {
		this.datafiles = datafiles;
		this.checkSum = 0;
		this.details = null;
	}

	/**
	 * @return the cpuUsage
	 */
	@XmlElement(name = "cpuUsage")
	public InstanceCpuUsage getCpuUsage() {
		return cpuUsage;
	}

	/**
	 * @param cpuUsage
	 *            the cpuUsage to set
	 */
	public void setCpuUsage(InstanceCpuUsage cpuUsage) {
		this.cpuUsage = cpuUsage;
		this.checkSum = 0;
		this.details = null;
	}

	/**
	 * @return the ioUsage
	 */
	@XmlElement(name = "ioUsage")
	public InstanceIoUsage getIoUsage() {
		return ioUsage;
	}

	/**
	 * @param ioUsage
	 *            the ioUsage to set
	 */
	public void setIoUsage(InstanceIoUsage ioUsage) {
		this.ioUsage = ioUsage;
		this.checkSum = 0;
		this.details = null;
	}
	
	/**
	 * 
	 * @return
	 */
	@XmlTransient
	public int getCheckSum() {
		return checkSum;
	}
	
	/**
	 * 
	 * @param checkSum
	 */
	public void setCheckSum(int checkSum) {
		this.checkSum = checkSum;
	}
	
	/**
	 * 
	 * @return
	 */
	@XmlTransient
	public Date getTimeDetected() {
		return timeDetected;
	}
	
	/**
	 * 
	 * @param timeDetected
	 */
	public void setTimeDetected(Date timeDetected) {
		this.timeDetected = timeDetected;
	}
	
	/**
	 * 
	 */
	public String getDetails() {
		return details;
	}
	
	/**
	 * 
	 * @param details
	 */
	public void setDetails(String details) {
		this.details = details;
	}

}

