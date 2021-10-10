package com.binance.client;

import com.binance.client.model.enums.*;

public class PostOrderRequest {
  private final String symbol;
  private final OrderSide side;
  private final PositionSide positionSide;
  private final OrderType orderType;
  private final TimeInForce timeInForce;
  private final String quantity;
  private final String price;
  private final String reduceOnly;
  private final String newClientOrderId;
  private final String stopPrice;
  private final WorkingType workingType;
  private final NewOrderRespType newOrderRespType;
  private final boolean closePosition;

  /**
   */
  public PostOrderRequest(String symbol, OrderSide side, PositionSide positionSide, OrderType orderType, TimeInForce timeInForce, String quantity, String price, String reduceOnly, String newClientOrderId, String stopPrice, WorkingType workingType, NewOrderRespType newOrderRespType, boolean closePosition) {
    this.symbol = symbol;
    this.side = side;
    this.positionSide = positionSide;
    this.orderType = orderType;
    this.timeInForce = timeInForce;
    this.quantity = quantity;
    this.price = price;
    this.reduceOnly = reduceOnly;
    this.newClientOrderId = newClientOrderId;
    this.stopPrice = stopPrice;
    this.workingType = workingType;
    this.newOrderRespType = newOrderRespType;
    this.closePosition = closePosition;
  }

  public String getSymbol() {
    return symbol;
  }

  public OrderSide getSide() {
    return side;
  }

  public PositionSide getPositionSide() {
    return positionSide;
  }

  public OrderType getOrderType() {
    return orderType;
  }

  public TimeInForce getTimeInForce() {
    return timeInForce;
  }

  public String getQuantity() {
    return quantity;
  }

  public String getPrice() {
    return price;
  }

  public String getReduceOnly() {
    return reduceOnly;
  }

  public String getNewClientOrderId() {
    return newClientOrderId;
  }

  public String getStopPrice() {
    return stopPrice;
  }

  public WorkingType getWorkingType() {
    return workingType;
  }

  public NewOrderRespType getNewOrderRespType() {
    return newOrderRespType;
  }

  public boolean getClosePosition() {
    return closePosition;
  }

  @Override
  public String toString() {
    return "PostOrderRequest{" +
            "symbol='" + symbol + '\'' +
            ", side=" + side +
            ", orderType=" + orderType +
            ", quantity='" + quantity + '\'' +
            ", price='" + price + '\'' +
            ", stopPrice='" + stopPrice + '\'' +
            ", workingType=" + workingType +
            '}';
  }
}
