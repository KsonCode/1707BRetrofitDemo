package com.laoxu.a1707bretrofitdemo.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.laoxu.a1707bretrofitdemo.entity.GreendaoEntity;

import com.laoxu.a1707bretrofitdemo.greendao.GreendaoEntityDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig greendaoEntityDaoConfig;

    private final GreendaoEntityDao greendaoEntityDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        greendaoEntityDaoConfig = daoConfigMap.get(GreendaoEntityDao.class).clone();
        greendaoEntityDaoConfig.initIdentityScope(type);

        greendaoEntityDao = new GreendaoEntityDao(greendaoEntityDaoConfig, this);

        registerDao(GreendaoEntity.class, greendaoEntityDao);
    }
    
    public void clear() {
        greendaoEntityDaoConfig.clearIdentityScope();
    }

    public GreendaoEntityDao getGreendaoEntityDao() {
        return greendaoEntityDao;
    }

}
