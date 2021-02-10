package terra.db

import kotliquery.LoanPattern
import kotliquery.queryOf
import kotliquery.sessionOf
import javax.sql.DataSource

class Persistence(private val dataSource: DataSource) {

    fun entryExists(entryId: String): Boolean {
        val sql = """
            SELECT EXISTS(
                SELECT id
                FROM entry
                WHERE id = ?
            )
        """

        val query = queryOf(sql, entryId).map { row -> row.boolean(1) }.asSingle
        val exists = LoanPattern.using(sessionOf(dataSource)) { session ->
            session.run(query)
        }
        return exists ?: false
    }

}
