package jlu.hibernate.contact;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.BootstrapServiceRegistry;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;

public class Bootstrap {
	public static void main(String[] args) {
		BootstrapServiceRegistryBuilder bsrb = new BootstrapServiceRegistryBuilder();
		BootstrapServiceRegistry registry = bsrb.build();

		MetadataSources sources = new MetadataSources(registry);
		sources.addAnnotatedClass(SimpleContact.class);

		MetadataBuilder mdBuilder = sources.getMetadataBuilder();
		mdBuilder.applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE);

		Metadata metadata = mdBuilder.build();

		SessionFactory sf = metadata.buildSessionFactory();
	}
}
