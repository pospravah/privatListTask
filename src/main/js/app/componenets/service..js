var request = require( 'request' ) ;

function list( filter, callback ) {
    var options = {
        url: 'http://endpoint:port',
        method: 'GET',
        json: filter
    } ;
    request( options, function( err, res, body ) {
        if ( err ) {
            callback( err ) ;
        }
        callback( null, body ) ;
    } ) ;
}

exports.list = list ;