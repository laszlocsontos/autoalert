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
package info.geekinaction.autoalert.view.ui;

import info.geekinaction.autoalert.model.domain.Datafile;
import info.geekinaction.autoalert.view.AbstractAutoAlertListPanel;
import info.geekinaction.autoalert.view.AutoAlertDisplay;
import info.geekinaction.autoalert.view.model.DatafileDataModel;

/**
 * @author lcsontos
 * 
 */
public class DatafileStatusPanel extends AbstractAutoAlertListPanel<Datafile, DatafileDataModel> {

	public DatafileStatusPanel() {
		super(AutoAlertDisplay.STORAGE_DATAFILES, new DatafileDataModel());
	}
	
	@Override
	protected void controllerCallback() {
		controller.onStorageDatafilesRefresh();
	}

}
