package linklike



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Link)
class LinkTests {

	void testCreatLink() {
		def link = new Link(title: 'Hotmail', link:'www.hotmail.com',likecounts:0)
		assert link != null
	}

	void testDefaultLink() {
		def link = new Link(title: 'Hotmail', link:'www.hotmail.com',likecounts:0)
		assertEquals 0, link.likecounts
	}

}