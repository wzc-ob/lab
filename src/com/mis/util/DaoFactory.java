package com.mis.util;

import com.mis.dao.FilefolderDao;
import com.mis.dao.impl.FilefolderDaoImpl;
import com.mis.model.Filefolder;

public class DaoFactory {
	public static FilefolderDao igetFilefolder() {
		return new FilefolderDaoImpl();
	}

}
