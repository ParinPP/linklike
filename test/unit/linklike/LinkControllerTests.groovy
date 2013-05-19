package linklike



import grails.test.mixin.*
import org.junit.*
import grails.test.mixin.domain.DomainClassUnitTestMixin
/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */

@TestFor(LinkController)
@TestMixin(DomainClassUnitTestMixin)
@Mock([Link])
class LinkControllerTests {

   	void testIndex() {
   		mockDomain(Link,
            [  [title:'Google', url:'www.google.com'],
               [title:'Kapook', url:'www.kapook.com'],
               [title:'Sanook', url:'www.sanook.com']
               ]
         )
   		def model = controller.index()
   		assert model.links.size() == 3
   	}

   	void testCheckLinkAndVote() {
   		mockDomain(Link,
            [  [title:'Google', url:'www.google.com'],
               [title:'Hotmail', url:'www.hotmail.com'],
               [title:'Sanook', url:'www.sanook.com']]
         )
         
         def hotmailWeb = Link.get(2)
         assert hotmailWeb != null
         assertEquals 0, hotmailWeb.likecounts
         assertEquals 'www.hotmail.com', hotmailWeb.url
         assertEquals 2, hotmailWeb.id
         
   	}


   	void testVoteUpAndDown() {
         mockDomain(Link,
            [  [title:'Google', url:'www.google.com'],
               [title:'Hotmail', url:'www.hotmail.com'],
               [title:'Sanook', url:'www.sanook.com']]
         )
         

         def hotmailWeb = Link.get(2)
         assert hotmailWeb != null

         // like test
         assertEquals 0, hotmailWeb.likecounts
         controller.likeLinkActivity(hotmailWeb)
         assertEquals 1, hotmailWeb.likecounts
         controller.likeLinkActivity(hotmailWeb)
         assertEquals 2, hotmailWeb.likecounts

         // unlike test
         controller.unLikeLinkActivity(hotmailWeb)
         assertEquals 1, hotmailWeb.likecounts
         controller.unLikeLinkActivity(hotmailWeb)
         assertEquals 0, hotmailWeb.likecounts

         // like can not be negative
         controller.unLikeLinkActivity(hotmailWeb)
         assertEquals 0, hotmailWeb.likecounts
   	}
}