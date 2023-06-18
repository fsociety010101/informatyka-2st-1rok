from django.shortcuts import redirect

from cart.cart import Cart
from order.models import Order, OrderItem


def start_order(request):
    cart = Cart(request)
    total_price = 0

    items = []
    for item in cart:
        product = item['product']
        total_price += product.price * int(item['quantity'])

    if request.method == 'POST':
        first_name = request.POST.get('first_name')
        last_name = request.POST.get('last_name')
        email = request.POST.get('email')
        address = request.POST.get('address')
        zipcode = request.POST.get('zipcode')
        city = request.POST.get('city')
        phone = request.POST.get('phone')

        order = Order.objects.create(user=request.user, first_name=first_name, last_name=last_name, email=email,
                                     address=address, zipcode=zipcode, city=city, phone=phone)
        order.paid_amount = total_price
        order.paid = True
        order.save()

        for item in cart:
            product = item['product']
            quantity = int(item['quantity'])
            price = product.price * quantity

            item = OrderItem.objects.create(order=order, product=product, price=price, quantity=quantity)

    cart.clear()
    return redirect('success')
