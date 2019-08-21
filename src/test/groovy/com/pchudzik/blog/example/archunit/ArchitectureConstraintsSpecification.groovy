package com.pchudzik.blog.example.archunit

import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition
import spock.lang.Specification

class ArchitectureConstraintsSpecification extends Specification {
    def "all test classes follow naming convention"() {
        given:
        final allClasses = new ClassFileImporter().importPackages("com.pchudzik.blog.example.archunit")
        final rule = ArchRuleDefinition.classes().that()
                .areAssignableTo(Specification.class)
                .should().haveNameMatching(".*ArchSpecification\$")
                .orShould().haveNameMatching(".*IntegrationSpecification\$")
                .orShould().haveNameMatching(".*UnitSpecification\$")

        expect:
        rule.check(allClasses)
    }

    def "internal api can not leak to public api"() {
        given:
        final allClasses = new ClassFileImporter().importPackages("com.pchudzik.blog.example.archunit")
        final rule = ArchRuleDefinition.noClasses().that()
                .resideInAPackage("..api..")
                .should()
                .dependOnClassesThat().resideInAPackage("..internal..")

        expect:
        rule.check(allClasses)
    }
}
