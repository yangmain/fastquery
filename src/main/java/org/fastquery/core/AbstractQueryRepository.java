/*
 * Copyright (c) 2016-2088, fastquery.org and/or its affiliates. All rights reserved.
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * For more information, please see http://www.fastquery.org/.
 * 
 */

package org.fastquery.core;

import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Map;
import java.util.function.IntSupplier;
import org.fastquery.page.Page;

/**
 * 
 * @author mei.sir@aliyun.cn
 */
public abstract class AbstractQueryRepository implements QueryRepository {

	private static final String EXECUTE_BATCH = "executeBatch";

	private static final String SAVE_TO_ID = "saveToId";

	private static final String SAVE_ARRAY = "saveArray";

	private static final String EXECUTE_UPDATE = "executeUpdate";

	private static final String EXECUTE_SAVE_OR_UPDATE = "executeSaveOrUpdate";

	private static final String UPDATE = "update";

	private static final String DELETE = "delete";

	private static final String SAVE = "save";

	private static final String INSERT = "insert";

	private Class<QueryRepository> c = QueryRepository.class;

	private static final MethodInfo[] m = new MethodInfo[35];

	private void cache(int j, String name, Class<?>... parameterTypes) {
		Method localMethod;
		try {
			localMethod = this.c.getMethod(name, parameterTypes);
		} catch (Exception localException) {
			throw new RepositoryException(localException);
		}
		// 针对此处的m是线程安全的
		m[j] = new MethodInfo(localMethod);	
	}

	@Override
	public int[] executeBatch(String paramString1, String paramString2) {
		int j = 0;
		if (m[j] == null) {
			cache(j, EXECUTE_BATCH, String.class, String.class);
		}
		return (int[]) Prepared.excute(m[j], new Object[] { paramString1, paramString2 }, this);
	}

	@Override
	public int[] executeBatch(String paramString) {
		int j = 1;
		if (m[j] == null) {
			cache(j, EXECUTE_BATCH, String.class);
		}
		return (int[]) Prepared.excute(m[j], new Object[] { paramString }, this);
	}

	@Override
	public int[] executeBatch(String paramString1, String paramString2, String[] paramArrayOfString) {
		int j = 2;
		if (m[j] == null) {
			cache(j, EXECUTE_BATCH, String.class, String.class, String[].class);
		}
		return (int[]) Prepared.excute(m[j], new Object[] { paramString1, paramString2, paramArrayOfString }, this);
	}

	@Override
	public int tx(IntSupplier paramSupplier) {
		int j = 3;
		if (m[j] == null) {
			cache(j, "tx", IntSupplier.class);
		}
		return ((Integer) Prepared.excute(m[j], new Object[] { paramSupplier }, this)).intValue();
	}

	@Override
	public BigInteger saveToId(Object paramObject) {
		int j = 4;
		if (m[j] == null) {
			cache(j, SAVE_TO_ID, Object.class);
		}
		return (BigInteger) Prepared.excute(m[j], new Object[] { paramObject }, this);
	}

	@Override
	public BigInteger saveToId(String paramString1, String paramString2, Object paramObject) {
		int j = 5;
		if (m[j] == null) {
			cache(j, SAVE_TO_ID, String.class, String.class, Object.class);
		}
		return (BigInteger) Prepared.excute(m[j], new Object[] { paramString1, paramString2, paramObject }, this);
	}

	@Override
	public BigInteger saveToId(Object paramObject, String paramString) {
		int j = 6;
		if (m[j] == null) {
			cache(j, SAVE_TO_ID, Object.class, String.class);
		}
		return (BigInteger) Prepared.excute(m[j], new Object[] { paramObject, paramString }, this);
	}

	@Override
	public int saveArray(boolean paramBoolean, String paramString1, String paramString2, Object... paramArrayOfObject) {
		int j = 7;
		if (m[j] == null) {
			cache(j, SAVE_ARRAY, boolean.class, String.class, String.class, Object[].class);
		}
		return ((Integer) Prepared.excute(m[j], new Object[] { Boolean.valueOf(paramBoolean), paramString1, paramString2, paramArrayOfObject },
				this)).intValue();
	}

	@Override
	public int saveArray(boolean paramBoolean, String paramString, Object... paramArrayOfObject) {
		int j = 8;
		if (m[j] == null) {
			cache(j, SAVE_ARRAY, boolean.class, String.class, Object[].class);
		}
		return ((Integer) Prepared.excute(m[j], new Object[] { Boolean.valueOf(paramBoolean), paramString, paramArrayOfObject }, this))
				.intValue();
	}

	@Override
	public int saveArray(boolean paramBoolean, Object... paramArrayOfObject) {
		int j = 9;
		if (m[j] == null) {
			cache(j, SAVE_ARRAY, boolean.class, Object[].class);
		}
		return ((Integer) Prepared.excute(m[j], new Object[] { Boolean.valueOf(paramBoolean), paramArrayOfObject }, this)).intValue();
	}

	@Override
	public int executeUpdate(String paramString, Object paramObject) {
		int j = 10;
		if (m[j] == null) {
			cache(j, EXECUTE_UPDATE, String.class, Object.class);
		}
		return ((Integer) Prepared.excute(m[j], new Object[] { paramString, paramObject }, this)).intValue();
	}

	@Override
	public int executeUpdate(Object paramObject) {
		int j = 11;
		if (m[j] == null) {
			cache(j, EXECUTE_UPDATE, Object.class);
		}
		return ((Integer) Prepared.excute(m[j], new Object[] { paramObject }, this)).intValue();
	}

	@Override
	public int executeUpdate(String paramString1, String paramString2, Object paramObject) {
		int j = 12;
		if (m[j] == null) {
			cache(j, EXECUTE_UPDATE, String.class, String.class, Object.class);
		}
		return ((Integer) Prepared.excute(m[j], new Object[] { paramString1, paramString2, paramObject }, this)).intValue();
	}

	@Override
	public int executeSaveOrUpdate(String paramString1, String paramString2, Object paramObject) {
		int j = 13;
		if (m[j] == null) {
			cache(j, EXECUTE_SAVE_OR_UPDATE, String.class, String.class, Object.class);
		}
		return ((Integer) Prepared.excute(m[j], new Object[] { paramString1, paramString2, paramObject }, this)).intValue();
	}

	@Override
	public int executeSaveOrUpdate(String paramString, Object paramObject) {
		int j = 14;
		if (m[j] == null) {
			cache(j, EXECUTE_SAVE_OR_UPDATE, String.class, Object.class);
		}
		return ((Integer) Prepared.excute(m[j], new Object[] { paramString, paramObject }, this)).intValue();
	}

	@Override
	public int executeSaveOrUpdate(Object paramObject) {
		int j = 15;
		if (m[j] == null) {
			cache(j, EXECUTE_SAVE_OR_UPDATE, Object.class);
		}
		return ((Integer) Prepared.excute(m[j], new Object[] { paramObject }, this)).intValue();
	}

	@Override
	public int update(String paramString1, String paramString2, Object paramObject, String paramString3) {
		int j = 16;
		if (m[j] == null) {
			cache(j, UPDATE, String.class, String.class, Object.class, String.class);
		}
		return ((Integer) Prepared.excute(m[j], new Object[] { paramString1, paramString2, paramObject, paramString3 }, this)).intValue();
	}

	@Override
	public <E> int update(String paramString, Collection<E> paramCollection) {
		int j = 17;
		if (m[j] == null) {
			cache(j, UPDATE, String.class, Collection.class);
		}
		return ((Integer) Prepared.excute(m[j], new Object[] { paramString, paramCollection }, this)).intValue();
	}

	@Override
	public int update(String paramString1, Object paramObject, String paramString2) {
		int j = 18;
		if (m[j] == null) {
			cache(j, UPDATE, String.class, Object.class, String.class);
		}
		return ((Integer) Prepared.excute(m[j], new Object[] { paramString1, paramObject, paramString2 }, this)).intValue();
	}

	@Override
	public int update(Object paramObject, String paramString) {
		int j = 19;
		if (m[j] == null) {
			cache(j, UPDATE, Object.class, String.class);
		}
		return ((Integer) Prepared.excute(m[j], new Object[] { paramObject, paramString }, this)).intValue();
	}

	@Override
	public <E> int update(String paramString1, String paramString2, Collection<E> paramCollection) {
		int j = 20;
		if (m[j] == null) {
			cache(j, UPDATE, String.class, String.class, Collection.class);
		}
		return ((Integer) Prepared.excute(m[j], new Object[] { paramString1, paramString2, paramCollection }, this)).intValue();
	}

	@Override
	public <E> int update(Collection<E> paramCollection) {
		int j = 21;
		if (m[j] == null) {
			cache(j, UPDATE, Collection.class);
		}
		return ((Integer) Prepared.excute(m[j], new Object[] { paramCollection }, this)).intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <E> E find(Class<E> paramClass, long paramLong, String paramString1, String paramString2) {
		int j = 22;
		if (m[j] == null) {
			cache(j, "find", Class.class, long.class, String.class, String.class);
		}
		return (E) Prepared.excute(m[j], new Object[] { paramClass, Long.valueOf(paramLong), paramString1, paramString2 }, this);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <E> E find(Class<E> paramClass, long paramLong) {
		int j = 23;
		if (m[j] == null) {
			cache(j, "find", Class.class, long.class);
		}
		return (E) Prepared.excute(m[j], new Object[] { paramClass, Long.valueOf(paramLong) }, this);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <E> E find(Class<E> paramClass, long paramLong, String paramString) {
		int j = 24;
		if (m[j] == null) {
			cache(j, "find", Class.class, long.class, String.class);
		}
		return (E) Prepared.excute(m[j], new Object[] { paramClass, Long.valueOf(paramLong), paramString }, this);
	}

	@Override
	public int delete(String paramString1, String paramString2, long paramLong, String paramString3) {
		int j = 25;
		if (m[j] == null) {
			cache(j, DELETE, String.class, String.class, long.class, String.class);
		}
		return ((Integer) Prepared.excute(m[j], new Object[] { paramString1, paramString2, Long.valueOf(paramLong), paramString3 }, this))
				.intValue();
	}

	@Override
	public int delete(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4) {
		int j = 26;
		if (m[j] == null) {
			cache(j, DELETE, String.class, String.class, long.class, String.class, String.class);
		}
		return ((Integer) Prepared.excute(m[j], new Object[] { paramString1, paramString2, Long.valueOf(paramLong), paramString3, paramString4 },
				this)).intValue();
	}

	@Override
	public int delete(String paramString1, String paramString2, long paramLong) {
		int j = 27;
		if (m[j] == null) {
			cache(j, DELETE, String.class, String.class, long.class);
		}
		return ((Integer) Prepared.excute(m[j], new Object[] { paramString1, paramString2, Long.valueOf(paramLong) }, this)).intValue();
	}

	@Override
	public <B> int save(boolean paramBoolean, Collection<B> paramCollection) {
		int j = 28;
		if (m[j] == null) {
			cache(j, SAVE, boolean.class, Collection.class);
		}
		return ((Integer) Prepared.excute(m[j], new Object[] { Boolean.valueOf(paramBoolean), paramCollection }, this)).intValue();
	}

	@Override
	public <B> int save(boolean paramBoolean, String paramString1, String paramString2, Collection<B> paramCollection) {
		int j = 29;
		if (m[j] == null) {
			cache(j, SAVE, boolean.class, String.class, String.class, Collection.class);
		}
		return ((Integer) Prepared.excute(m[j], new Object[] { Boolean.valueOf(paramBoolean), paramString1, paramString2, paramCollection },
				this)).intValue();
	}

	@Override
	public <B> int save(boolean paramBoolean, String paramString, Collection<B> paramCollection) {
		int j = 30;
		if (m[j] == null) {
			cache(j, SAVE, boolean.class, String.class, Collection.class);
		}
		return ((Integer) Prepared.excute(m[j], new Object[] { Boolean.valueOf(paramBoolean), paramString, paramCollection }, this)).intValue();
	}

	@Override
	public int insert(String paramString1, String paramString2, Object paramObject) {
		int j = 31;
		if (m[j] == null) {
			cache(j, INSERT, String.class, String.class, Object.class);
		}
		return ((Integer) Prepared.excute(m[j], new Object[] { paramString1, paramString2, paramObject }, this)).intValue();
	}

	@Override
	public int insert(Object paramObject, String paramString) {
		int j = 32;
		if (m[j] == null) {
			cache(j, INSERT, Object.class, String.class);
		}
		return ((Integer) Prepared.excute(m[j], new Object[] { paramObject, paramString }, this)).intValue();
	}

	@Override
	public int insert(Object paramObject) {
		int j = 33;
		if (m[j] == null) {
			cache(j, INSERT, Object.class);
		}
		return ((Integer) Prepared.excute(m[j], new Object[] { paramObject }, this)).intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<Map<String, Object>> findPage(QueryBuilder builder, boolean count, int pageIndex, int pageSize) {
		int j = 34;
		if (m[j] == null) {
			cache(j, "findPage", QueryBuilder.class,boolean.class,int.class,int.class);
		}
		return (Page<Map<String, Object>>) Prepared.excute(m[j], new Object[] { builder, Boolean.valueOf(count), Integer.valueOf(pageIndex), Integer.valueOf(pageSize) }, this);
	}
	
}
