package doxflow.models.diagram

import common.Element
import common.Diagram.Color.GREEN
import common.IElement
import doxflow.dsl.context
import doxflow.models.diagram.Relationship.Companion.DEFAULT
import doxflow.models.diagram.Relationship.Companion.NONE

class Participant(override val element: Element, type: Type, val context: context) : Party {
    init {
        element.stereoType = type.name.lowercase()
        element.backgroundColor = GREEN
        element.name = context.element.name + element.name
    }

    enum class Type {
        PARTY,
        PLACE,
        THING
    }

    infix fun play(role: Role): Role = role.apply {
        this@Participant.element.relate(role.element, Relationship.PLAY_TO)
    }

    fun relate(iElement: IElement, relationship: String = NONE) = apply {
        element.relate(iElement.element, relationship)
    }

    override fun toString(): String = buildString {
        appendLine(element)
    }
}
