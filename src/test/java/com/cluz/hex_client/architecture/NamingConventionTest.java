package com.cluz.hex_client.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.cluz.hex_client")
public class NamingConventionTest {

	private final static String CONSUMER_PACKAGE = "..com.cluz.hex_client.adapters.in.consumer";
	private final static String REPOSITORY_PACKAGE = "..com.cluz.hex_client.adapters.out.repository";

	@ArchTest
	public static final ArchRule consumer_reside_only_consumer_package = classes()
			.that()
			.haveNameMatching(".*Consumer")
			.should()
			.resideInAPackage(CONSUMER_PACKAGE)
			.as("Consumer classes should be only in the consumer package in adapters.in.consumer");

	@ArchTest
	public static final ArchRule repositories_reside_only_repository_package = classes()
			.that()
			.haveNameMatching(".*Repository")
			.should()
			.resideInAPackage(REPOSITORY_PACKAGE)
			.as("Repository classes should be only in the repository package in adapters.out.repository");

	@ArchTest
	public static final ArchRule mappers_reside_in_any_package = classes()
			.that()
			.haveNameMatching(".*Mapper")
			.should()
			.resideInAnyPackage("..adapters.in.consumer.mapper", "..adapters.in.controller.mapper",
					"..adapters.out.client.mapper", "..adapters.out.repository.mapper")
			.as("Mappers classes should resides in any of theses package");

	//TODO: config, message, controller, request, response, adapters, client, repository, entity, usecase, ports

	//SUFIX RULES
	@ArchTest
	public static final ArchRule should_be_suffixed_consumer = classes()
			.that()
			.resideInAnyPackage("..consumer")
			.should()
			.haveSimpleNameEndingWith("Consumer");

	@ArchTest
	public static final ArchRule should_be_suffixed_adapter = classes()
			.that()
			.resideInAnyPackage("..adapters.out")
			.should()
			.haveSimpleNameEndingWith("Adapter");

	@ArchTest
	public static final ArchRule should_be_suffixed_usecase = classes()
			.that()
			.resideInAnyPackage("..application.core.usecase")
			.should()
			.haveSimpleNameEndingWith("UseCase");

	@ArchTest
	public static final ArchRule should_be_suffixed_ports_in = classes()
			.that()
			.resideInAnyPackage("..application.ports..")
			.should()
			.haveSimpleNameEndingWith("Port");

	@ArchTest
	public static final ArchRule should_be_suffixed_config= classes()
			.that()
			.resideInAnyPackage("..config")
			.should()
			.haveSimpleNameEndingWith("Config");

	// TODO: suffixeds - message, controller,response, request, client.

}
