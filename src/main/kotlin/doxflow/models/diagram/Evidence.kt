package doxflow.models.diagram

import common.ChildElement

import common.Diagram
import common.Diagram.Color.PINK
import common.Diagram.Color.YELLOW
import common.Element
import doxflow.models.ability.BusinessAbility
import doxflow.dsl.context
import doxflow.models.ability.BusinessAbilityTable

abstract class Evidence<T>(
    val element: Element,
    val context: context,
    val role: Role? = null,
    private val note: String? = null,
    override var resource: String = ""
) : ChildElement(element, context), BusinessAbility<T>, Diagram.KeyInfo<T>, Relationship {
    init {
        element.backgroundColor = PINK
    }

    var isRole: Boolean = false
        set(value) {
            if (value) element.backgroundColor = YELLOW
            field = value
        }
    var timestamps: Array<out String>? = null
    private var data: Array<out String>? = null

    /**
     * Evidence的类型：包括rfp，proposal，contract，request, confirmation
     * */
    abstract val type: String

    open fun getUriPrefix(): String = ""

    override var relationship_type: RelationShipType = RelationShipType.ONE_TO_ONE

    open fun getUri(): String = when (relationship_type) {
        RelationShipType.ONE_TO_ONE -> "${getUriPrefix()}/$resource"
        RelationShipType.ONE_TO_N -> "${getUriPrefix()}/${resource.pluralize()}/{${resource[0]}id}"
        else -> "${getUriPrefix()}/$resource"
    }

    open fun addBusinessAbility(table: BusinessAbilityTable) {
        if (resource.isBlank()) return
        val roleName = role?.element?.displayName ?: ""
        val serviceName = "${context.element.displayName}服务"
        val singularUri: String
        when (relationship_type) {
            RelationShipType.ONE_TO_ONE -> {
                singularUri = "${getUriPrefix()}/$resource"
                table.addRow(
                    BusinessAbilityTable.Row(
                        "POST",
                        singularUri,
                        "创建${element.displayName}",
                        serviceName,
                        roleName
                    )
                )
            }
            RelationShipType.ONE_TO_N -> {
                val pluralUri = "${getUriPrefix()}/${resource.pluralize()}"
                singularUri = "$pluralUri/{${resource[0]}id}"
                table.addRow(
                    BusinessAbilityTable.Row(
                        "POST",
                        pluralUri,
                        "创建${element.displayName}",
                        serviceName,
                        roleName
                    )
                )
                table.addRow(BusinessAbilityTable.Row("GET", pluralUri, "查看${element.displayName}列表", serviceName))
            }
            else -> singularUri = "${getUriPrefix()}/$resource"
        }
        table.addRow(BusinessAbilityTable.Row("GET", singularUri, "查看${element.displayName}", serviceName, roleName))
        table.addRow(BusinessAbilityTable.Row("PUT", singularUri, "更改${element.displayName}", serviceName, roleName))
        table.addRow(BusinessAbilityTable.Row("DELETE", singularUri, "取消${element.displayName}", serviceName, roleName))
    }

    override fun key_timestamps(vararg timestamps: String) = timestamps.let { this.timestamps = it }

    override fun key_data(vararg data: String) = data.let { this.data = it }

    override fun toString(): String {
        return """
            |${note ?: ""}
            |$element {
            |   ${if (!isRole) generateRole(role) ?: "" else ""} ${timestamps?.joinToString() ?: ""}
            |   ${if (timestamps != null && data != null) "..\n" else ""} ${data?.joinToString() ?: ""}
            |}
        """.trimIndent()
    }


    private fun generateRole(role: Role?): String? = role?.let {
        """
            |<${role.element.backgroundColor}> <size:14>${role.element.displayName}</size> |
            |..
            |
        """.trimIndent()
    }
}