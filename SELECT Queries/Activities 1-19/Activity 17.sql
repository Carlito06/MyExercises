-- Activity 17
SELECT InvoiceId, Description, Price, Quantity, ServiceDate, (Price * Quantity) AS Line_item_total
FROM invoicelineitem
WHERE (Price * Quantity) BETWEEN 15.0 AND 25.0

