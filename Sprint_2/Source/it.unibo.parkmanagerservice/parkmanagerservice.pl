%====================================================================================
% parkmanagerservice description   
%====================================================================================
context(ctxclientparkinmock, "localhost",  "TCP", "10101").
context(ctxparkmanagerservice, "localhost",  "TCP", "10000").
context(ctxtrolley, "localhost",  "TCP", "10200").
context(ctxbasicrobot, "localhost",  "TCP", "8020").
 qactor( clientparkinmock, ctxclientparkinmock, "it.unibo.clientparkinmock.Clientparkinmock").
  qactor( parkmanagerservice, ctxparkmanagerservice, "it.unibo.parkmanagerservice.Parkmanagerservice").
  qactor( trolley, ctxtrolley, "it.unibo.trolley.Trolley").
