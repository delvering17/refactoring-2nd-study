```JavaScript
const orderData = orderString.split(/\s+/);
const product = priceList[orderData[0].split("-")[1]];
const orderPrice = parseInt(orderData[1]) * productPrice;

---
const orderRecord = parseOrder(order);
const orderPrice = price(orderRecord, priceList);

function parseOrder();
function price();

```
- 핵심은 단계를 명확하게 하는데 있다.