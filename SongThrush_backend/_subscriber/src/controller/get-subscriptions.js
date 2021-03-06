module.exports = function makeGetSubscription({readSubscriptions}){
   
    return async function getSubscription(httpRequest){
        
        const id = httpRequest.id;

        try {
            const readed = await readSubscriptions(id);
        
            return {
                headers: {
                    'Content-Type': 'application/json',
                },
                statusCode: 200,
                body: readed
            }            
        
        } catch (e) {
        
            return {
                headers: {
                    'Content-Type': 'application/json',
                },
                statusCode: 400,
                body: e.message
            }
        
        }

    }
}