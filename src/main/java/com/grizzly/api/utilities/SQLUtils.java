package com.grizzly.api.utilities;

import java.util.Arrays;

public class SQLUtils {

    /**
     * Loops through all objects and formats correlating for sql syntax
     *
     * @param objects
     * @return the sql syntax formatted for the values in VALUES (value, value, value);
     */
    public static String formatObjectsToValues(final Object... objects) {
        final StringBuilder sql = new StringBuilder();

        sql.append("VALUES (");

        for (int index = 0; index < objects.length; index++) {
            Object obj = objects[index];
            if (obj instanceof String) {
                sql.append("'").append(obj).append("'").append(index == objects.length - 1 ? "" : ", ");
            }
            if (obj instanceof Integer || obj instanceof Long || obj instanceof Byte || obj instanceof Short || obj instanceof Float || obj instanceof Double) {
                sql.append(obj).append(index == objects.length -1 ? "" : ", ");
            }
        }

        sql.append(");");
        return sql.toString();
    }
}
