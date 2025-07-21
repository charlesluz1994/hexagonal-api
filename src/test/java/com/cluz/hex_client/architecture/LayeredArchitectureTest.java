package com.cluz.hex_client.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "com.cluz.hex_client")
public class LayeredArchitectureTest {

	@ArchTest
	public static final ArchRule layered_architecture_test = layeredArchitecture()
			.consideringAllDependencies()
			//Definition of layers names.
			.layer("AdapterInput").definedBy("..adapters.in..")
			.layer("AdapterOutput").definedBy("..adapters.out..")
			.layer("UseCase").definedBy("..application.core.usecase..")
			.layer("PortsInput").definedBy("..application.ports.in..")
			.layer("PortsOutput").definedBy("..application.ports.out..")
			.layer("Config").definedBy("..config..")

			//Definition of restrictions between layers.
			.whereLayer("AdapterInput").mayOnlyBeAccessedByLayers("Config")
			.whereLayer("AdapterOutput").mayOnlyBeAccessedByLayers("Config")
			.whereLayer("UseCase").mayOnlyBeAccessedByLayers( "Config")
			.whereLayer("PortsInput").mayOnlyBeAccessedByLayers("AdapterInput", "UseCase")
			.whereLayer("PortsOutput").mayOnlyBeAccessedByLayers("AdapterOutput", "UseCase")
			.whereLayer("Config").mayNotBeAccessedByAnyLayer() ;

}
