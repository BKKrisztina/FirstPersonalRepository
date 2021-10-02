package application.database;

import application.helpers.EnumHelper;

public class QueryBuilder {

        private StringBuilder query;

        public QueryBuilder() {
            query = new StringBuilder();
        }

        public QueryBuilder select(TableName tableName, ColumnName... columnNames) {
            query.append("SELECT ");
            if (columnNames.length > 0) {
                addColumns(columnNames);
            } else {
                query.append("*");
            }
            query.append(" FROM ")
                    .append(EnumHelper.getDBName(tableName, false));
            return this;
        }

        private void addColumns(ColumnName... columnNames) {
            for (ColumnName columnName : columnNames) {
                query.append(EnumHelper.getDBName(columnName, false))
                        .append(", ");
            }
            query.setLength(query.length() - 2);
        }
}
