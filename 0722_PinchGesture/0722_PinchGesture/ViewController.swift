//
//  ViewController.swift
//  0722_PinchGesture
//
//  Created by Seong A Oh on 2021/07/22.
//

import UIKit

class ViewController: UIViewController {
    
    
    @IBOutlet weak var imgPinch: UIImageView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Pinch Setup
        let pinch = UIPinchGestureRecognizer(target: self, action: #selector(ViewController.doPinch(_ :)))
        self.view.addGestureRecognizer(pinch)
    }
    
    // alt(Option) 키 누르고 드래그
    @objc func doPinch(_ pinch: UIPinchGestureRecognizer){
        imgPinch.transform = imgPinch.transform.scaledBy(x: pinch.scale, y: pinch.scale) // 크기 변형
        pinch.scale = 1 // scale factor를 1.0으로 다시 재설정하지 않으면 조금만 Pinch Gesture를 취해도 엄청나게 이미지가 확대되거나 축소
    }


} // ViewController

