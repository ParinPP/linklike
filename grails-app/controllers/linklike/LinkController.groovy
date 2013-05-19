package linklike

class LinkController {
    def finded_link;

    def index() { 
        def links = Link.findAll()
        [ links: links ]
    }

    def create() {
        def link = new Link(title: params.title, url: params.url)
        link.save()
        redirect(action: "index")
    }

    def linkLink() {
        finded_link = Link.get(params.id)
        likeLinkActivity(finded_link); 
        redirect(action: "index")
    }

    def unLikeLink() {
        finded_link = Link.get(params.id)
        unLikeLinkActivity(finded_link);
        redirect(action: "index")
    }

    def likeLinkActivity(l){
        finded_link = l
        finded_link.likecounts++;
        finded_link.save(); 
    }

    def unLikeLinkActivity(l){
        finded_link = l
        if(finded_link.likecounts>0){
        finded_link.likecounts--;
        finded_link.save();
        }
    }

}